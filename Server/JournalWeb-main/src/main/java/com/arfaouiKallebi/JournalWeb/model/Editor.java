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
@Table(name = "editor")
public class Editor extends User {


    @OneToMany(mappedBy = "editor")
    @Column(name = "invitations")
    private List<Invitation> invitations ;
}
