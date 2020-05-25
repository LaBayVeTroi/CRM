package com.teko.domain;

import com.teko.proto.UserTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
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
    private String username;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_admin")
    private boolean isAdmin;
    private boolean isStaff;
    @Column(name = "date_joined")
    private Date dateJoined;
    @Column(name = "role")
    private String role;
    @Column(name = "proile_pic")
    private File profilePic;
    @Column(name = "has_sales_access")
    private boolean hasSalesAccess;
    @Column(name = "has_marketing_access")
    private boolean hasMarketingAccess;

    public static User fromProto(UserTranfer userTranfer) {
        return User.builder()
                .id(userTranfer.getId())
                .username(userTranfer.getUsername())
                .firstName(userTranfer.getFirstName())
                .lastName(userTranfer.getLastName())
                .email(userTranfer.getEmail())
                .isActive(userTranfer.getIsActive())
                .isAdmin(userTranfer.getIsAdmin())
                .isStaff(userTranfer.getStaff())
                .dateJoined(new Date(userTranfer.getDateJoined()))
                .profilePic(new File(userTranfer.getProfilePic()))
                .hasMarketingAccess(userTranfer.getHasMarketingAccess())
                .hasSalesAccess(userTranfer.getHasSalesAccess())
                .build();
    }

    public UserTranfer toProto(){
        return UserTranfer.newBuilder()
                .setId(this.id)
                .setUsername(this.username)
                .setFirstName(this.firstName)
                .setLastName(this.lastName)
                .setEmail(this.email)
                .setIsActive(this.isActive)
                .setIsAdmin(this.isAdmin)
                .setStaff(this.isStaff)
                .setDateJoined(this.dateJoined.getTime())
                .setProfilePic(this.profilePic.getAbsolutePath())
                .setHasMarketingAccess(this.hasMarketingAccess)
                .setHasSalesAccess(this.hasSalesAccess)
                .build();
    }
}
