package com.arfaouiKallebi.JournalWeb.controller.api;

import com.arfaouiKallebi.JournalWeb.dto.AuthorDTO;
import com.arfaouiKallebi.JournalWeb.dto.CommentDTO;
import com.arfaouiKallebi.JournalWeb.dto.ItemDTO;
import com.arfaouiKallebi.JournalWeb.dto.ManuscriptDTO;
import com.arfaouiKallebi.JournalWeb.model.Attachment;
import com.arfaouiKallebi.JournalWeb.model.Item;
import com.arfaouiKallebi.JournalWeb.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/authors/{idauth}")
@CrossOrigin(origins = "*")
public class AuthorController {
    @Autowired
    private ManuscriptService manuscriptService ;
    @Autowired
    private CommentService commentService ;
    @Autowired
    private AuthorService authorService ;
    @Autowired
    private AttachmentService attachmentService ;
    @Autowired
    private ObjectMapper objectMapper ;
    @Autowired
    private ItemService itemService ;

    @GetMapping("manuscripts")
    public List<ManuscriptDTO> getManuscripts(@PathVariable Long idauth){
        return manuscriptService.findManuscripts(idauth) ;
    }
    @DeleteMapping("manuscripts/delete/{id}")
    public ResponseEntity<?> deleteManuscriptById(@PathVariable Long id){
        return manuscriptService.deleteById(id);
    }
    @PostMapping("manuscripts/save")
    public ManuscriptDTO saveManuscript(@PathVariable Long idauth , @RequestBody ManuscriptDTO manuscript){
        return manuscriptService.saveManuscript(idauth , manuscript);
    }
    @GetMapping("manuscripts/processed")
    public List<ManuscriptDTO> getProcessedManuscripts(@PathVariable Long idauth){
        return manuscriptService.getProcessedManuscripts(idauth);
    }
    @GetMapping("manuscripts/sentBack")
    public List<ManuscriptDTO> getSentBackManuscripts(@PathVariable Long idauth){
        return manuscriptService.getSentBackManuscripts(idauth);
    }
    @GetMapping("manuscripts/incomplete")
    public List<ManuscriptDTO> getIncompleteManuscripts(@PathVariable Long idauth){
        return manuscriptService.getIncompleteManuscripts(idauth);
    }
    @GetMapping("manuscripts/waiting")
    public List<ManuscriptDTO> getWaitingManuscripts(@PathVariable Long idauth){
        return manuscriptService.getWaitingManuscripts(idauth);
    }
    @GetMapping("manuscripts/{idman}/items")
    public List<ItemDTO> getItems(@PathVariable Long idman){
        return itemService.getItems(idman) ;
    }
    @GetMapping("manuscripts/{idman}/items/{id}")
    public ItemDTO getItemById(@PathVariable Long id){
        return itemService.findById(id) ;
    }
    @DeleteMapping("manuscripts/{idman}/items/delete/{id}")
    public ResponseEntity<?> deleteItemById(@PathVariable Long id){
        return itemService.deleteById(id);
    }
    @PostMapping("manuscripts/{idman}/items/save")
    public ItemDTO saveItem( @PathVariable Long idman , @RequestParam("model") String item , @RequestParam("file") MultipartFile file) throws Exception {
        Item itemObj = objectMapper.readValue(item ,Item.class) ;
        ItemDTO itemDTO = ItemDTO.fromEntity(itemObj) ;
        return itemService.save( idman,  itemDTO , file); }
    @GetMapping("manuscripts/{idman}/items/{iditem}/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long iditem , @PathVariable String fileId) throws Exception {
        Attachment attachment = null;

        attachment = itemService.findById(iditem).getAttachment() ;
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getFileName()
                                + "\"")
                .body(new ByteArrayResource(attachment.getData()));
    }
    @GetMapping("manuscripts/{idman}/comments")
    public List<CommentDTO> getComments(@PathVariable Long idman ){
        return commentService.getComments(idman) ;
    }
    @DeleteMapping("manuscripts/{idman}/comments/delete/{id}")
    public ResponseEntity<?> deleteCommentById( @PathVariable Long id){
        return commentService.deleteById(id);
    }
    @PostMapping("manuscripts/{idman}/comments/save")
    public CommentDTO saveComment(@PathVariable Long idman ,@RequestBody CommentDTO comment){
        return commentService.saveComment(idman , comment) ;
    }
    @GetMapping("manuscripts/{idman}/authors/add/{author}")
    public List<AuthorDTO> addAuthor(@PathVariable Long idman , @PathVariable Long author){
        return authorService.addAuthor(idman , author) ;
    }


}
