package com.teko.domain;

import com.teko.proto.APISettingTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "api_setting")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class APISetting {
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
    @Column(name = "api_key")
    private String apiKey;
    private String website;
    @Column(name = "created_on")
    private Date createdOn;

    @ManyToMany
    @JoinTable(name = "api_setting_lead_assigned", joinColumns = @JoinColumn(name = "api_setting_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @OneToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToMany
    @JoinTable(name = "api_setting_tag", joinColumns = @JoinColumn(name = "apt_setting_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    public static APISetting fromProto(APISettingTranfer apiSettingTranfer){
        List<User> users = new ArrayList<>();
        apiSettingTranfer.getUsersList().forEach(userTranfer -> {
            users.add(User.fromProto(userTranfer));
        });
        List<Tag> tags = new ArrayList<>();
        apiSettingTranfer.getTagsList().forEach(tagTranfer -> {
            tags.add(new Tag().fromProto(tagTranfer));
        });
        return APISetting.builder()
                .id(apiSettingTranfer.getId())
                .title(apiSettingTranfer.getTitle())
                .apiKey(apiSettingTranfer.getApiKey())
                .createdBy(User.fromProto(apiSettingTranfer.getCreatedBy()))
                .createdOn(new Date(apiSettingTranfer.getCreatedOn()))
                .tags(tags)
                .users(users)
                .website(apiSettingTranfer.getWebsite())
                .build();
    }

    public APISettingTranfer toProto(){
        APISettingTranfer.Builder builder = APISettingTranfer.newBuilder();
        for (int i=0;i<this.users.size();i++){
            builder.setUsers(i,this.users.get(i).toProto());
        }
        for (int i=0;i<this.tags.size();i++){
            builder.setTags(i,this.tags.get(i).toProto());
        }
        builder.setId(this.id)
                .setTitle(this.title)
                .setApiKey(this.apiKey)
                .setCreatedBy(this.createdBy.toProto())
                .setCreatedOn(this.createdOn.getTime())
                .setWebsite(this.website);
        return builder.build();
    }
}
