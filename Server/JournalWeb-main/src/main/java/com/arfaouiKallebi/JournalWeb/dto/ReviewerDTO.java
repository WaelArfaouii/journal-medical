package com.arfaouiKallebi.JournalWeb.dto;


import com.arfaouiKallebi.JournalWeb.model.Reviewer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ReviewerDTO {

    private Long id;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String jobTitle ;
    private String country ;
    private String address ;
    private String phoneNumber ;
    private String institution ;
    private String role ;
    @JsonIgnore
    private List<InvitationDTO> invitations ;

    public static ReviewerDTO fromEntity(Reviewer reviewer) {
        if (reviewer == null) {
            return null;
        }
        return ReviewerDTO.builder()
                .id(reviewer.getId())
                .firstName(reviewer.getFirstName())
                .lastName(reviewer.getLastName())
                .email(reviewer.getEmail())
                .jobTitle(reviewer.getJobTitle())
                .phoneNumber(reviewer.getPhoneNumber())
                .institution(reviewer.getInstitution())
                .address(reviewer.getAddress())
                .role("Reviewer")
                .country(reviewer.getCountry())
                .build();
    }

    public static Reviewer toEntity(ReviewerDTO reviewerDTO) {
        if (reviewerDTO == null) {
            return null;
        }
        Reviewer reviewer = new Reviewer();
        reviewer.setFirstName(reviewerDTO.getFirstName());
        reviewer.setLastName(reviewerDTO.getLastName());
        reviewer.setEmail(reviewerDTO.getEmail());
        reviewer.setJobTitle(reviewerDTO.getJobTitle());
        reviewer.setInstitution(reviewerDTO.getInstitution());
        reviewer.setJobTitle(reviewerDTO.getJobTitle());
        reviewer.setPhoneNumber(reviewer.getPhoneNumber());
        reviewer.setCountry(reviewer.getCountry());
        reviewer.setAddress(reviewerDTO.getAddress());
        return reviewer;
    }

}
