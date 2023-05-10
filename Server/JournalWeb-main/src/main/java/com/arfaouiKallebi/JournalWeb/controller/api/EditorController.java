package com.arfaouiKallebi.JournalWeb.controller.api;

import com.arfaouiKallebi.JournalWeb.dto.InvitationDTO;
import com.arfaouiKallebi.JournalWeb.dto.ReviewerDTO;
import com.arfaouiKallebi.JournalWeb.services.InvitationService;
import com.arfaouiKallebi.JournalWeb.services.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

@RestController
@RequestMapping("api/editors/{idedit}")
public class EditorController {
    
    @Autowired
    private ReviewerService reviewerService ;
    @Autowired
    private InvitationService invitationService ;
    @GetMapping("reviewers")
    public List<ReviewerDTO> getReviewers(){
        return reviewerService.findAll() ;
    }
    @GetMapping("reviewers/{id}")
    public ReviewerDTO getReviewerById(@PathVariable Long id){
        return reviewerService.findById(id) ;
    }
    @DeleteMapping("reviewers/delete/{id}")
    public ResponseEntity<?> deleteReviewerById(@PathVariable Long id){
        return reviewerService.deleteById(id);
    }
    @PostMapping("reviewers/save")
    public ReviewerDTO saveReviewer(@RequestBody ReviewerDTO reviewer){
        return reviewerService.save(reviewer) ;
    }

    @GetMapping("invitations")
    public List<InvitationDTO> getinvitations(@PathVariable Long idedit ){
        return invitationService.findAll() ;
    }
    @DeleteMapping("invitations/delete/{id}")
    public InvitationDTO deleteinvitationById(@PathVariable Long idedit , @PathVariable Long id){
        return invitationService.deleteById(id);
    }
    @PostMapping("invitations/reviewer/{idrev}/manuscript/{idman}")
    public InvitationDTO saveinvitation(@PathVariable Long idedit ,@PathVariable Long idrev , @PathVariable Long idman ,@RequestBody InvitationDTO invitation){
        return invitationService.sendInvitation(idedit ,idrev ,idman , invitation) ;

    }
    @GetMapping("manuscript/{idman}")
    public ResponseEntity<?> rejectManuscipt(@PathVariable Long idman ){
        return invitationService.rejectManuscript(idman);
    }
}
