package com.arfaouiKallebi.JournalWeb.security;
import com.arfaouiKallebi.JournalWeb.model.Author;
import com.arfaouiKallebi.JournalWeb.model.Editor;
import com.arfaouiKallebi.JournalWeb.model.Reviewer;
import com.arfaouiKallebi.JournalWeb.repository.AuthorRepository;
import com.arfaouiKallebi.JournalWeb.repository.EditorRepository;
import com.arfaouiKallebi.JournalWeb.repository.ReviewerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private EditorRepository editorRepository ;
    @Autowired
    private ReviewerRepository reviewerRepository ;
    @Autowired
    private AuthorRepository authorRepository ;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if(authorRepository.existsByEmail(email)){
            Author author = authorRepository.findByEmail(email);
            return  author ;
        }
        else if(reviewerRepository.existsByEmail(email)){
            Reviewer reviewer = reviewerRepository.findByEmail(email);
            return  reviewer ;
        }
        else if (editorRepository.existsByEmail(email)){
            Editor editor = editorRepository.findByEmail(email);
            return  editor ;
        }
        else throw  new UsernameNotFoundException("User not found !") ;


    }


}
