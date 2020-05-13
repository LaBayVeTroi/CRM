package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "document")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "document_file")
    private File documentFile;
    @Column(name = "created_on")
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
