package com.arfaouiKallebi.JournalWeb.repository;

import com.arfaouiKallebi.JournalWeb.dto.ItemDTO;
import com.arfaouiKallebi.JournalWeb.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Modifying
    @Query(value = "delete  from Item a where a.id =:id")
    void deleteItemById(Long id);
    @Query(value = "select i from Item i where i.manuscript.id = :idman")
    List<Item> getItems(Long idman);
}
