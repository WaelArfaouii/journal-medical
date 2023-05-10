package com.arfaouiKallebi.JournalWeb.repository;

import com.arfaouiKallebi.JournalWeb.dto.ManuscriptDTO;
import com.arfaouiKallebi.JournalWeb.model.Item;
import com.arfaouiKallebi.JournalWeb.model.Manuscript;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Transactional
public interface ManuscriptRepository extends JpaRepository<Manuscript,Long> {
    @Query("SELECT m FROM Manuscript m WHERE m.status = 'processed' and m.submitter.id = :idauth")
    List<Manuscript> getProcessedManuscripts(Long idauth);
    @Query("SELECT m FROM Manuscript m WHERE m.status = 'sentBack' and m.submitter.id = :idauth")
    List<Manuscript> getSentBackManuscripts(Long idauth);
    @Query("SELECT m FROM Manuscript m WHERE m.status = 'incompleted' and m.submitter.id = :idauth ")
    List<Manuscript> getIncompleteManuscripts(Long idauth);
    @Query("SELECT m FROM Manuscript m WHERE m.status = 'waiting' and m.submitter.id = :idauth ")
    List<Manuscript>  getWaitingManuscripts(Long idauth);
    @Query("SELECT m FROM Manuscript m WHERE m.submitter.id = :idauth  ")
    List<Manuscript> getManuscripts(Long idauth);
    @Query("SELECT m FROM Manuscript m WHERE m.id = :id ")
    Manuscript findManById(Long id);
    @Modifying
    @Query("UPDATE Manuscript m SET m.items = :items WHERE m.id = :idman")
    void setManuscriptItems(Long idman, List<Item> items);

    @Modifying
    @Query(value = "delete  from Manuscript a where a.id =:id")
    void deleteManById(Long id);
    @Modifying
    @Transactional
    @Query(value = "update Manuscript m set m.status='sentBack' where m.id =:idman")
    void rejectManuscript(Long idman);
}
