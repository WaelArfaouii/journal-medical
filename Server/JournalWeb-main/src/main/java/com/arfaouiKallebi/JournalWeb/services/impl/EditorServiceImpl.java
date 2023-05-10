package com.arfaouiKallebi.JournalWeb.services.impl;

import com.arfaouiKallebi.JournalWeb.dto.AuthorDTO;
import com.arfaouiKallebi.JournalWeb.dto.EditorDTO;
import com.arfaouiKallebi.JournalWeb.dto.EditorDTO;
import com.arfaouiKallebi.JournalWeb.exception.ErrorCodes;
import com.arfaouiKallebi.JournalWeb.exception.InvalidEntityException;
import com.arfaouiKallebi.JournalWeb.repository.EditorRepository;
import com.arfaouiKallebi.JournalWeb.services.EditorService;
import com.arfaouiKallebi.JournalWeb.validator.AuthorValidator;
import com.arfaouiKallebi.JournalWeb.validator.EditorValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
//Logger
@Slf4j
public class EditorServiceImpl implements EditorService {
    @Autowired
    private EditorRepository editorRepository ;
    @Override
    public List<EditorDTO> findAll() {
        return null;
    }

    @Override
    public EditorDTO findById(Long id) {
        return null;
    }

    @Override
    public EditorDTO deleteById(Long id) {

        return EditorDTO.fromEntity(editorRepository.deleteEditorById(id));
    }

    @Override
    public EditorDTO save(EditorDTO dto) {
        List<String> errors = EditorValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Editor is not valid {}", dto);
            throw new InvalidEntityException("Editor is not valid", ErrorCodes.EDITOR_CLIENT_NOT_VALID, errors);
        }
        return EditorDTO.fromEntity(
                editorRepository.save(
                        EditorDTO.toEntity(dto)
                )
        );
    }
}
