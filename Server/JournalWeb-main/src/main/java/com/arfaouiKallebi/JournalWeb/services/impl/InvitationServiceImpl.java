package com.arfaouiKallebi.JournalWeb.services.impl;
import com.arfaouiKallebi.JournalWeb.dto.InvitationDTO;
import com.arfaouiKallebi.JournalWeb.dto.ManuscriptDTO;
import com.arfaouiKallebi.JournalWeb.exception.ErrorCodes;
import com.arfaouiKallebi.JournalWeb.exception.InvalidEntityException;
import com.arfaouiKallebi.JournalWeb.model.Invitation;
import com.arfaouiKallebi.JournalWeb.repository.EditorRepository;
import com.arfaouiKallebi.JournalWeb.repository.InvitationRepository;
import com.arfaouiKallebi.JournalWeb.repository.ManuscriptRepository;
import com.arfaouiKallebi.JournalWeb.repository.ReviewerRepository;
import com.arfaouiKallebi.JournalWeb.services.InvitationService;
import com.arfaouiKallebi.JournalWeb.validator.InvitationValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//Logger
@Slf4j
public class InvitationServiceImpl implements InvitationService {
    @Autowired
    private InvitationRepository invitationRepository ;
    @Autowired
    private EditorRepository editorRepository ;
    @Autowired
    private ReviewerRepository reviewerRepository ;
    @Autowired
    private ManuscriptRepository manuscriptRepository ;
    @Override
    public List<InvitationDTO> findAll() {
        return null;
    }

    @Override
    public InvitationDTO findById(Long id) {
        return null;
    }

    @Override
    public InvitationDTO deleteById(Long id) {

        return InvitationDTO.fromEntity(invitationRepository.deleteInvitationById(id));
    }

    @Override
    public InvitationDTO save(InvitationDTO dto) {
        List<String> errors = InvitationValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Invitation is not valid {}", dto);
            throw new InvalidEntityException("Invitation is not valid ", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        return InvitationDTO.fromEntity(
                invitationRepository.save(
                        InvitationDTO.toEntity(dto)
                )
        );
    }

    @Override
    public InvitationDTO sendInvitation(Long idedit, Long idrev, Long idman, InvitationDTO invitation) {
        Invitation inv = InvitationDTO.toEntity(invitation) ;
        inv.setEditor(editorRepository.getReferenceById(idedit));
        inv.setReviewer(reviewerRepository.getReferenceById(idrev));
        inv.setManuscript(manuscriptRepository.getReferenceById(idman));
        Invitation in = invitationRepository.save(inv)  ;
        System.out.println(in.getId());
        return InvitationDTO.fromEntity(in) ;

    }

    @Override
    public ResponseEntity<?> rejectManuscript(Long idman) {
        manuscriptRepository.rejectManuscript(idman) ;
        return new ResponseEntity<>("Manuscript Rejected !" , HttpStatus.OK) ;
    }

    @Override
    public List<InvitationDTO> getInvitations(Long idrev) {

        return invitationRepository.getInvitations(idrev).stream().map(
                InvitationDTO::fromEntity
        ).collect(Collectors.toList());


    }

    @Override
    public List<InvitationDTO> getInvitationsReviewed(Long idrev) {
        return invitationRepository.getInvitationsReviewed(idrev).stream().map(
                InvitationDTO::fromEntity
        ).collect(Collectors.toList());
    }

    @Override
    public List<InvitationDTO> getPendingInvitations(Long idrev) {
        return invitationRepository.getPendingInvitations(idrev).stream().map(
                InvitationDTO::fromEntity
        ).collect(Collectors.toList());
    }
}
