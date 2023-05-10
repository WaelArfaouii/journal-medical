package com.arfaouiKallebi.JournalWeb.dto;
import com.arfaouiKallebi.JournalWeb.model.Editor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditorDTO {

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
    public static EditorDTO fromEntity(Editor editor) {
        if (editor == null) {
            return null;
        }
        return EditorDTO.builder()
                .id(editor.getId())
                .firstName(editor.getFirstName())
                .lastName(editor.getLastName())
                .email(editor.getEmail())
                .jobTitle(editor.getJobTitle())
                .phoneNumber(editor.getPhoneNumber())
                .institution(editor.getInstitution())
                .role("Editor")
                .address(editor.getAddress())
                .build();
    }

    public static Editor toEntity(EditorDTO editorDTO) {
        if (editorDTO == null) {
            return null;
        }
        Editor editor = new Editor();
        editor.setFirstName(editorDTO.getFirstName());
        editor.setLastName(editorDTO.getLastName());
        editor.setEmail(editorDTO.getEmail());
        editor.setJobTitle(editorDTO.getJobTitle());
        editor.setInstitution(editorDTO.getInstitution());
        editor.setJobTitle(editorDTO.getJobTitle());
        editor.setPhoneNumber(editor.getPhoneNumber());
        editor.setAddress(editorDTO.getAddress());




        return editor;
    }

}
