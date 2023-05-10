package com.arfaouiKallebi.JournalWeb.services;


import com.arfaouiKallebi.JournalWeb.dto.ManuscriptDTO;
import com.arfaouiKallebi.JournalWeb.model.Item;
import com.arfaouiKallebi.JournalWeb.model.Manuscript;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ManuscriptService {

    Manuscript findById(Long id);

    ManuscriptDTO save(ManuscriptDTO dto);

    List<ManuscriptDTO> getIncompleteManuscripts(Long idauth);

    List<ManuscriptDTO> getWaitingManuscripts(Long idauth);

    List<ManuscriptDTO> findManuscripts(Long idauth);

    ManuscriptDTO saveManuscript(Long idauth, ManuscriptDTO manuscript);

    List<ManuscriptDTO> getProcessedManuscripts(Long idauth);

    List<ManuscriptDTO> getSentBackManuscripts(Long idauth);
    void setManuscriptItems(Long idman , List<Item> items) ;

    ResponseEntity<?> deleteById(Long id);
}
