package com.arfaouiKallebi.JournalWeb.services.impl;

import com.arfaouiKallebi.JournalWeb.dto.ItemDTO;
import com.arfaouiKallebi.JournalWeb.dto.ManuscriptDTO;
import com.arfaouiKallebi.JournalWeb.model.Attachment;
import com.arfaouiKallebi.JournalWeb.model.Item;
import com.arfaouiKallebi.JournalWeb.model.Manuscript;
import com.arfaouiKallebi.JournalWeb.repository.ItemRepository;
import com.arfaouiKallebi.JournalWeb.services.AttachmentService;
import com.arfaouiKallebi.JournalWeb.services.ItemService;
import com.arfaouiKallebi.JournalWeb.services.ManuscriptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
//Logger
@Slf4j
public class ItemServiceImpl implements ItemService {
    @Autowired
    private AttachmentService attachmentService ;
    @Autowired
    private ManuscriptService manuscriptService ;
    @Autowired
    private ItemRepository itemRepository ;


    @Override
    public ItemDTO findById(Long id) {
        return ItemDTO.fromEntity(itemRepository.getReferenceById(id));
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {

        itemRepository.deleteItemById(id);
        return  new ResponseEntity<>("item deleted !", HttpStatus.OK);
    }



    @Override
    public ItemDTO save(Long idman , ItemDTO dto , MultipartFile file) throws Exception{
        Attachment attachment = attachmentService.saveAttachment(file) ;
        Item item = ItemDTO.toEntity(dto) ;
        Manuscript man = manuscriptService.findById(idman) ;
        item.setAttachment(attachment);
        item.setManuscript(man);
        man.getItems().add(item) ;
        Item item1 = itemRepository.save(item) ;
        return ItemDTO.fromEntity(item1) ;

        }

    @Override
    public List<ItemDTO> getItems(Long idman) {
        System.out.println(idman);
        return itemRepository.getItems(idman).stream()
                .map(ItemDTO::fromEntity)
                .collect(Collectors.toList());

    }


}

