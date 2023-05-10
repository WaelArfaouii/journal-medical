package com.arfaouiKallebi.JournalWeb.services;

import com.arfaouiKallebi.JournalWeb.dto.InvitationDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InvitationService {
    List<InvitationDTO> findAll() ;
    InvitationDTO findById(Long id) ;
    InvitationDTO deleteById(Long id) ;

    InvitationDTO save(InvitationDTO dto);

    InvitationDTO sendInvitation(Long idedit, Long idrev, Long idman, InvitationDTO invitation);

    ResponseEntity<?> rejectManuscript(Long idman);

    List<InvitationDTO> getInvitations(Long idrev);

    List<InvitationDTO> getInvitationsReviewed(Long idrev);

    List<InvitationDTO> getPendingInvitations(Long idrev);
}
