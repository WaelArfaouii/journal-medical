package com.arfaouiKallebi.JournalWeb.repository;

import com.arfaouiKallebi.JournalWeb.model.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EditorRepository extends JpaRepository<Editor,Long > {
    Boolean existsByEmail(String email);
    @Query(value = "delete  from Editor a where a.id =:id")
    Editor deleteEditorById(Long id);
    @Query(value = "select a  from Editor a where a.email =:name")
    Editor findByEmail(String name);
}
