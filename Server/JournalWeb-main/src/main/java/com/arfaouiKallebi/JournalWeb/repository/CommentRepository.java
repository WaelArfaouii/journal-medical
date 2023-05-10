package com.arfaouiKallebi.JournalWeb.repository;

import ch.qos.logback.core.testUtil.MockInitialContext;
import com.arfaouiKallebi.JournalWeb.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment , Long> {
    @Query(value = "delete  from Comment a where a.id =:id")
    Comment deleteCommentById(Long id);
    @Query(value = "select c from Comment c where c.manuscript.id = :idman")
    List<Comment> getComments(Long idman);
}
