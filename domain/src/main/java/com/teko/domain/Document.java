package com.teko.domain;

import com.teko.proto.DocumentTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
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
    private User createdBy;

    @ManyToMany
    @JoinTable(name = "document_shared_to", joinColumns = @JoinColumn(name = "document_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> sharedTo;

    @ManyToMany
    @JoinTable(name = "document_team", joinColumns = @JoinColumn(name = "document_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> teams;

    public static Document fromProto(DocumentTranfer documentTranfer){
        List<User> users = new ArrayList<>();
        documentTranfer.getSharedToList().forEach(userTranfer -> {
            users.add(User.fromProto(userTranfer));
        });
        List<Team> teams = new ArrayList<>();
        documentTranfer.getTeamsList().forEach(teamTranfer -> {
            teams.add(Team.fromProto(teamTranfer));
        });
        return Document.builder()
                .id(documentTranfer.getId())
                .title(documentTranfer.getTitle())
                .documentFile(new File(documentTranfer.getDocumentFile()))
                .createdOn(new Date(documentTranfer.getCreatedOn()))
                .createdBy(User.fromProto(documentTranfer.getCreatedBy()))
                .sharedTo(users)
                .teams(teams)
                .build();
    }

    public DocumentTranfer toProto(){
        DocumentTranfer.Builder builder = DocumentTranfer.newBuilder();
        for(int i=0;i<this.sharedTo.size();i++){
            builder.setSharedTo(i,this.sharedTo.get(i).toProto());
        }
        for(int i=0;i<this.teams.size();i++){
            builder.setTeams(i,this.teams.get(i).toProto());
        }
        builder.setId(this.id)
                .setTitle(this.title)
                .setDocumentFile(this.documentFile.getAbsolutePath())
                .setCreatedOn(this.createdOn.getTime())
                .setCreatedBy(this.createdBy.toProto());
        return builder.build();
    }
}
