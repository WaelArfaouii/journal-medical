package com.arfaouiKallebi.JournalWeb.repository;

import com.arfaouiKallebi.JournalWeb.model.Invitation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Arrays;
import java.util.List;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    @Query(value = "delete  from Invitation a where a.id =:id")
    Invitation deleteInvitationById(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from Invitation i where i.reviewer.id = :id ")
    void deleteInv(Long id);

    @Query(value = "select i from Invitation i where i.reviewer.id = :idrev")
    List<Invitation> getInvitations(Long idrev);
    @Query(value = "select i from Invitation i where i.reviewer.id = :idrev and i.manuscript.status not like 'processed'")
    List<Invitation> getInvitationsReviewed(Long idrev);
    @Query(value = "select i from Invitation i where i.reviewer.id = :idrev and i.manuscript.status not like 'senBack'")
    List<Invitation> getPendingInvitations(Long idrev);
}
