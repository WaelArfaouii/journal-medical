package com.arfaouiKallebi.JournalWeb.repository;

import com.arfaouiKallebi.JournalWeb.model.Reviewer;
import com.arfaouiKallebi.JournalWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewerRepository extends JpaRepository<Reviewer,Long > {
    Boolean existsByEmail(String email);
    @Query(value = "select a  from Reviewer a where a.id =:id")
    Reviewer findRevById(Long id);
    @Query(value = "select a  from Reviewer a where a.email =:name")
    Reviewer findByEmail(String name);
}
