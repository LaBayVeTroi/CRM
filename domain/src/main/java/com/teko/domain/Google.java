package com.teko.domain;

import com.teko.proto.GoogleTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "google")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Google {
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
    @Column(name = "google_url")
    private String googleUrl;
    @Column(name = "verified_mail")
    private String verifiedMail;
    @Column(name = "family_name")
    private String familyName;
    private String name;
    private String gender;
    private String dob;
    private String givenName;
    private String email;

    @OneToOne
    @JoinColumn(name = "user")
    private User user;

    public static Google fromProto(GoogleTranfer googleTranfer){
        return Google.builder()
                .id(googleTranfer.getId())
                .googleUrl(googleTranfer.getGoogleUrl())
                .verifiedMail(googleTranfer.getVerifiedMail())
                .familyName(googleTranfer.getFamilyName())
                .name(googleTranfer.getName())
                .gender(googleTranfer.getGender())
                .dob(googleTranfer.getDob())
                .givenName(googleTranfer.getGivenName())
                .email(googleTranfer.getEmail())
                .user(User.fromProto(googleTranfer.getUser()))
                .build();
    }

    public GoogleTranfer toProto(){
        return GoogleTranfer.newBuilder()
                .setId(this.id)
                .setDob(this.dob)
                .setGoogleUrl(this.googleUrl)
                .setVerifiedMail(this.verifiedMail)
                .setFamilyName(this.familyName)
                .setGender(this.gender)
                .setName(this.name)
                .setGivenName(this.givenName)
                .setEmail(this.email)
                .setUser(this.user.toProto())
                .build();
    }
}
