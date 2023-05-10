package com.arfaouiKallebi.JournalWeb.services;

import com.arfaouiKallebi.JournalWeb.dto.ReviewerDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewerService {
    List<ReviewerDTO> findAll() ;
    ReviewerDTO findById(Long id) ;
    ResponseEntity<?> deleteById(Long id) ;
    ReviewerDTO save(ReviewerDTO dto);


}
