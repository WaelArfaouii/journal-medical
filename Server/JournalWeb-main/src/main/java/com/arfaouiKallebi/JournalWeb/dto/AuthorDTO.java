package com.arfaouiKallebi.JournalWeb.dto;

import com.arfaouiKallebi.JournalWeb.model.Author;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AuthorDTO {

    private Long id;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String jobTitle ;
    @JsonIgnore
    List<ManuscriptDTO> mauscripts ;
    private String address ;
    private String phoneNumber ;
    private String institution ;
    private String role  ;
    public static AuthorDTO fromEntity(Author author) {
        if (author == null) {
            return null;
        }
        return AuthorDTO.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .email(author.getEmail())
                .jobTitle(author.getJobTitle())
                .phoneNumber(author.getPhoneNumber())
                .institution(author.getInstitution())
                .role("Author")
                .address(author.getAddress())
                .build();
    }

    public static Author toEntity(AuthorDTO authorDTO) {
        if (authorDTO == null) {
            return null;
        }
        Author author = new Author();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setEmail(authorDTO.getEmail());
        author.setJobTitle(authorDTO.getJobTitle());
        author.setInstitution(authorDTO.getInstitution());
        author.setJobTitle(authorDTO.getJobTitle());
        author.setPhoneNumber(authorDTO.getPhoneNumber());
        author.setAddress(authorDTO.getAddress());

        return author;
    }
}
