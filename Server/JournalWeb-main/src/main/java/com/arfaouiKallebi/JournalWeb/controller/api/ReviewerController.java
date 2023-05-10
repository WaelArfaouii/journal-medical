package com.arfaouiKallebi.JournalWeb.controller.api;
import com.arfaouiKallebi.JournalWeb.dto.InvitationDTO;
import com.arfaouiKallebi.JournalWeb.services.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/reviewers/{idrev}")
public class ReviewerController {
    @Autowired
    private InvitationService invitationService ;

    @GetMapping("invitations")
    public List<InvitationDTO> getinvitations(@PathVariable Long idrev ){
        return invitationService.getInvitations(idrev) ;
    }
    @GetMapping("invitations/reviewed")
    public List<InvitationDTO> getinvitationsReviewed(@PathVariable Long idrev ){
        return invitationService.getInvitationsReviewed(idrev) ;
    }
    @GetMapping("invitations/pending")
    public List<InvitationDTO> getPendingInvitations(@PathVariable Long idrev ){
        return invitationService.getPendingInvitations(idrev) ;
    }
    
}
