package com.arfaouiKallebi.JournalWeb.dto;

import com.arfaouiKallebi.JournalWeb.model.Invitation;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class InvitationDTO {

    private Long id;
    private EditorDTO editorDTO ;
    private ReviewerDTO reviewerDTO ;
    private ManuscriptDTO manuscriptDTO ;
    private Instant createdDate ;

    public static InvitationDTO fromEntity(Invitation invitation) {
        if (invitation == null) {
            return null;
        }

        return InvitationDTO.builder()
                .id(invitation.getId())
                .editorDTO(EditorDTO.fromEntity(invitation.getEditor()))
                .reviewerDTO(ReviewerDTO.fromEntity(invitation.getReviewer()))
                .manuscriptDTO(ManuscriptDTO.fromEntity(invitation.getManuscript()))
                .createdDate(invitation.getCreatedDate())
                .build();
    }

    public static Invitation toEntity(InvitationDTO invitationDto) {
        if (invitationDto == null) {
            return null;
        }
        Invitation invitation = new Invitation();
        invitation.setManuscript(ManuscriptDTO.toEntity(invitationDto.getManuscriptDTO()));
        invitation.setReviewer(ReviewerDTO.toEntity(invitationDto.reviewerDTO) );
        invitation.setEditor(EditorDTO.toEntity(invitationDto.editorDTO) );
        return invitation;
    }

}
