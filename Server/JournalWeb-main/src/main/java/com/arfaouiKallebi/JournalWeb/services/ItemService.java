package com.arfaouiKallebi.JournalWeb.services;

import com.arfaouiKallebi.JournalWeb.dto.ItemDTO;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ItemService {
    ItemDTO findById(Long id) ;
    ResponseEntity<?> deleteById(Long id) ;

    ItemDTO save(Long idman , ItemDTO dto , MultipartFile file) throws Exception ;

    List<ItemDTO> getItems(Long idman);
}
