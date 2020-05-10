package com.example.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "id")
    private Integer id;
    private String title;
    private File documentFile;
    private Date createdOn;
    private String status;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User created_by;

    @ManyToMany
    @JoinTable(name = "document_shared_to", joinColumns = @JoinColumn(name = "document_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> sharedTo;

    @ManyToMany
    @JoinTable(name = "document_team", joinColumns = @JoinColumn(name = "document_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> teams;
}
