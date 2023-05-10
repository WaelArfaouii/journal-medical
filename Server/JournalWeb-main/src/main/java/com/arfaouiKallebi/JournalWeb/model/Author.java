package com.arfaouiKallebi.JournalWeb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class Author extends User {


    @ManyToMany(fetch = FetchType.EAGER  , cascade = CascadeType.PERSIST)
    @Column(name = "manuscripts")
    List<Manuscript> manuscripts ;


}
