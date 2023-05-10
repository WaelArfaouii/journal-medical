package com.arfaouiKallebi.JournalWeb.services;

import com.arfaouiKallebi.JournalWeb.dto.CommentDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {

    List<CommentDTO> getComments(Long idman);

    CommentDTO saveComment(Long idman, CommentDTO comment);

    ResponseEntity<?> deleteById(Long id);
}
