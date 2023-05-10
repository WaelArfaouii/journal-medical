package com.arfaouiKallebi.JournalWeb.services.impl;

import com.arfaouiKallebi.JournalWeb.dto.*;
import com.arfaouiKallebi.JournalWeb.model.*;
import com.arfaouiKallebi.JournalWeb.repository.*;
import com.arfaouiKallebi.JournalWeb.security.JwtUtilities;
import com.arfaouiKallebi.JournalWeb.services.IUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final AuthenticationManager authenticationManager ;
    @Autowired
    private EditorRepository editorRepository ;
    @Autowired
    private ReviewerRepository reviewerRepository ;
    @Autowired
    private AuthorRepository authorRepository ;
    private final IRoleRepository iRoleRepository ;
    private final PasswordEncoder passwordEncoder ;
    private final JwtUtilities jwtUtilities ;


    @Override
    public Role saveRole(Role role) {
        return iRoleRepository.save(role);
    }

    @Override
    public User saverUser(User user) {
        return null;
    }

    @Override
    public ResponseEntity<?> register(RegisterDto registerDto) {
        if(     authorRepository.existsByEmail(registerDto.getEmail()) ||
                reviewerRepository.existsByEmail(registerDto.getEmail()) ||
                editorRepository.existsByEmail(registerDto.getEmail())
        )
        { return  new ResponseEntity<>("email is already taken !", HttpStatus.SEE_OTHER); }
        else
        {

            Role role = new Role( );
            if (registerDto.getRole() != null) {
                switch (registerDto.getRole()) {

                    case "author" :
                        role = new Role(RoleName.AUTHOR) ;
                        Author author = new Author() ;
                        author.setEmail(registerDto.getEmail());
                        author.setFirstName(registerDto.getFirstName());
                        author.setLastName(registerDto.getLastName());
                        author.setPassword(passwordEncoder.encode(registerDto.getPassword()));
                        author.setPhoneNumber(registerDto.getPhoneNumber());
                        author.setInstitution(registerDto.getInstitution());
                        author.setJobTitle(registerDto.getJobTitle());
                        author.setAddress(registerDto.getAddress());
                        author.setCountry(registerDto.getCountry());
                        author.setRoles(Collections.singletonList(role));
                        Author auth = authorRepository.save(author);
                        String token1 = jwtUtilities.generateToken(auth.getId().toString() , registerDto.getEmail(),Collections.singletonList(role.getRoleName()));
                        return new ResponseEntity<>(new BearerToken(token1 , "Bearer "),HttpStatus.OK);

                    case "reviewer" :
                        role = new Role(RoleName.REVIEWER) ;
                        Reviewer reviewer = new Reviewer() ;
                        reviewer.setEmail(registerDto.getEmail());
                        reviewer.setFirstName(registerDto.getFirstName());
                        reviewer.setLastName(registerDto.getLastName());
                        reviewer.setPassword(passwordEncoder.encode(registerDto.getPassword()));
                        reviewer.setPhoneNumber(registerDto.getPhoneNumber());
                        reviewer.setInstitution(registerDto.getInstitution());
                        reviewer.setJobTitle(registerDto.getJobTitle());
                        reviewer.setAddress(registerDto.getAddress());
                        reviewer.setCountry(registerDto.getCountry());
                        reviewer.setRoles(Collections.singletonList(role));
                        Reviewer rev = reviewerRepository.save(reviewer);
                        String token2 = jwtUtilities.generateToken(rev.getId().toString() , registerDto.getEmail(),Collections.singletonList(role.getRoleName()));
                        return new ResponseEntity<>(new BearerToken(token2 , "Bearer "),HttpStatus.OK);
                    case "editor" :
                        role = new Role(RoleName.EDITOR) ;
                        Editor editor = new Editor() ;
                        editor.setEmail(registerDto.getEmail());
                        editor.setFirstName(registerDto.getFirstName());
                        editor.setLastName(registerDto.getLastName());
                        editor.setPassword(passwordEncoder.encode(registerDto.getPassword()));
                        editor.setPhoneNumber(registerDto.getPhoneNumber());
                        editor.setInstitution(registerDto.getInstitution());
                        editor.setJobTitle(registerDto.getJobTitle());
                        editor.setAddress(registerDto.getAddress());
                        editor.setCountry(registerDto.getCountry());
                        editor.setRoles(Collections.singletonList(role));
                        Editor ed = editorRepository.save(editor);
                        String token3 = jwtUtilities.generateToken(ed.getId().toString() , registerDto.getEmail(),Collections.singletonList(role.getRoleName()));
                        return new ResponseEntity<>(new BearerToken(token3 , "Bearer "),HttpStatus.OK);
                }
            }
            else {
                throw new UsernameNotFoundException("Role not sent ") ;

            }
            return null ;


        }
        }

    @Override
    public String authenticate(LoginDto loginDto) {
      Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if(authorRepository.existsByEmail(loginDto.getEmail())){
            Author user = authorRepository.findByEmail(authentication.getName()) ;
            List<String> rolesNames = new ArrayList<>();
            user.getRoles().forEach(r-> rolesNames.add(r.getRoleName()));
            String token = jwtUtilities.generateToken(user.getId().toString() , user.getUsername(),rolesNames);
            return token;
        }
        else if(reviewerRepository.existsByEmail(loginDto.getEmail())){
            Reviewer user = reviewerRepository.findByEmail(authentication.getName()) ;
            List<String> rolesNames = new ArrayList<>();
            user.getRoles().forEach(r-> rolesNames.add(r.getRoleName()));
            String token = jwtUtilities.generateToken(user.getId().toString() , user.getUsername(),rolesNames);
            return token;
        }
        else if (editorRepository.existsByEmail(loginDto.getEmail())){
            Editor user = editorRepository.findByEmail(authentication.getName()) ;
            List<String> rolesNames = new ArrayList<>();
            user.getRoles().forEach(r-> rolesNames.add(r.getRoleName()));
            String token = jwtUtilities.generateToken(user.getId().toString(),user.getUsername(),rolesNames);
            return token;
        }
        else { throw new UsernameNotFoundException("User not found") ;}


    }



}

