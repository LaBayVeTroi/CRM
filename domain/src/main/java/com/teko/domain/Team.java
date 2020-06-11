package com.teko.domain;

import com.teko.proto.TeamTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "team")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {
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
    private String name;
    @Column(length = 512)
    private String description;
    @Column(name = "created_on")
    private Date createdOn;

    @ManyToMany
    @JoinTable(name = "team_user", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @OneToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    public static Team fromProto(TeamTranfer teamTranfer){
        List<User> users = new ArrayList<>();
        teamTranfer.getUsersList().forEach(userTranfer -> {
            users.add(User.fromProto(userTranfer));
        });
        return Team.builder()
                .id(teamTranfer.getId())
                .name(teamTranfer.getName())
                .description(teamTranfer.getDescription())
                .createdOn(new Date(teamTranfer.getCreatedOn()))
                .users(users)
                .createdBy(User.fromProto(teamTranfer.getCreatedBy()))
                .build();
    }

    public TeamTranfer toProto() {
        TeamTranfer.Builder builder = TeamTranfer.newBuilder();
        for(int i=0;i<users.size();i++){
            builder.setUsers(i, this.users.get(i).toProto());
        }
        builder.setId(this.id)
                .setName(this.name)
                .setDescription(this.description)
                .setCreatedOn(this.createdOn.getTime())
                .setCreatedBy(this.createdBy.toProto());
        return builder.build();
    }
}
