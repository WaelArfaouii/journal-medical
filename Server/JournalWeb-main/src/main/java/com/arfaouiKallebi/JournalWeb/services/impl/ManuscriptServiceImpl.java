package com.arfaouiKallebi.JournalWeb.services.impl;

import com.arfaouiKallebi.JournalWeb.dto.ManuscriptDTO;
import com.arfaouiKallebi.JournalWeb.exception.EntityNotFoundException;
import com.arfaouiKallebi.JournalWeb.exception.ErrorCodes;
import com.arfaouiKallebi.JournalWeb.exception.InvalidEntityException;
import com.arfaouiKallebi.JournalWeb.model.Item;
import com.arfaouiKallebi.JournalWeb.model.Manuscript;
import com.arfaouiKallebi.JournalWeb.repository.AuthorRepository;
import com.arfaouiKallebi.JournalWeb.repository.ManuscriptRepository;
import com.arfaouiKallebi.JournalWeb.services.ManuscriptService;
import com.arfaouiKallebi.JournalWeb.validator.ManuscriptValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ManuscriptServiceImpl implements ManuscriptService {
    @Autowired
    private ManuscriptRepository manuscriptRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Manuscript findById(Long id) {
        return manuscriptRepository.findManById(id) ;
    }


    @Override
    public ManuscriptDTO save(ManuscriptDTO dto) {
        List<String> errors = ManuscriptValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Manuscript is not valid {}", dto);
            throw new InvalidEntityException("Manuscript is not valid ", ErrorCodes.MANUSCRIPT_NOT_VALID, errors);
        }
        return ManuscriptDTO.fromEntity(
                manuscriptRepository.save(
                        ManuscriptDTO.toEntity(dto)
                )
        );
    }


    @Override
    public List<ManuscriptDTO> getIncompleteManuscripts(Long idauth) {
        return manuscriptRepository.getIncompleteManuscripts(idauth).stream()
                .map(ManuscriptDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ManuscriptDTO> getWaitingManuscripts(Long idauth) {
        return manuscriptRepository.getWaitingManuscripts(idauth).stream()
                .map(ManuscriptDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ManuscriptDTO> findManuscripts(Long idauth) {
        return manuscriptRepository.getManuscripts(idauth).stream()
                .map(ManuscriptDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ManuscriptDTO saveManuscript(Long idauth, ManuscriptDTO manuscript) {
        Manuscript man = ManuscriptDTO.toEntity(manuscript) ;
        man.setSubmitter(authorRepository.findByAuthorId(idauth));
        return ManuscriptDTO.fromEntity(manuscriptRepository.save(man));
    }

    @Override
    public List<ManuscriptDTO> getProcessedManuscripts(Long idauth) {
        return manuscriptRepository.getProcessedManuscripts(idauth).stream()
                .map(ManuscriptDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ManuscriptDTO> getSentBackManuscripts(Long idauth) {
        return manuscriptRepository.getSentBackManuscripts(idauth).stream()
                .map(ManuscriptDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void setManuscriptItems(Long idman, List<Item> items) {
        manuscriptRepository.setManuscriptItems(idman,items) ;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        if (manuscriptRepository.existsById(id)){
            manuscriptRepository.deleteManById(id);
            return new ResponseEntity<>("Manuscript deleted !" , HttpStatus.OK);
        }
        throw new EntityNotFoundException(
                "No manuscript found ! ",
                ErrorCodes.USER_NOT_FOUND) ;

    }

}

