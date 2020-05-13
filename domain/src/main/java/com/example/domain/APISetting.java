package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
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
}
