package com.arfaouiKallebi.JournalWeb.repository;

import com.arfaouiKallebi.JournalWeb.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends JpaRepository<Author,Long > {
    Boolean existsByEmail(String email);
    @Query(value = "delete  from Author a where a.id =:id")
    Author deleteAuthorById(Long id);
    @Query(value = "select a  from Author a where a.email =:name")
    Author findByEmail(String name);
    @Query(value = "select a  from Author a where a.id =:id")
    Author findByAuthorId(Long id);
}
