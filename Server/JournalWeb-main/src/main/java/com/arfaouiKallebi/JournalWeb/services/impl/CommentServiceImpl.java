package com.arfaouiKallebi.JournalWeb.services.impl;
import com.arfaouiKallebi.JournalWeb.dto.CommentDTO;
import com.arfaouiKallebi.JournalWeb.model.Comment;
import com.arfaouiKallebi.JournalWeb.repository.CommentRepository;
import com.arfaouiKallebi.JournalWeb.services.CommentService;
import com.arfaouiKallebi.JournalWeb.services.ManuscriptService;
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
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository ;
    @Autowired
    private ManuscriptService manuscriptService ;

//    @Override
//    public CommentDTO save(CommentDTO dto) {
//
//        List<String> errors = CommentValidator.validate(dto);
//        if (!errors.isEmpty()) {
//            log.error("Comment is not valid {}", dto);
//            throw new InvalidEntityException("Comment is not valid ", ErrorCodes.COMMENT_NOT_VALID, errors);
//        }
//        return CommentDTO.fromEntity(
//                commentRepository.save(
//                        CommentDTO.toEntity(dto)
//                )
//        );
//    }

    @Override
    public List<CommentDTO> getComments(Long idman) {
        return commentRepository.getComments(idman).stream()
                .map(CommentDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO saveComment(Long idman, CommentDTO commentDTO) {
        Comment com = CommentDTO.toEntity(commentDTO) ;
        com.setManuscript(manuscriptService.findById(idman));
        Comment comment = commentRepository.save(com) ;
        return CommentDTO.fromEntity(comment);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        commentRepository.deleteById(id);
        return new ResponseEntity<>("Comment deleted" , HttpStatus.OK) ;
    }
}
