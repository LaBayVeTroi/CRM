package com.teko.domain;

import com.teko.proto.ProfileTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "profile")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
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
    @Column(name = "activation_key")
    private String activationKey;
    @Column(name = "key_expires")
    private Date keyExpires;

    public static Profile fromProto(ProfileTranfer profileTranfer) {
        return Profile.builder()
                .id(profileTranfer.getId())
                .activationKey(profileTranfer.getActivationKey())
                .keyExpires(new Date(profileTranfer.getKeyExpires()))
                .build();
    }

    public ProfileTranfer toProto() {
        return ProfileTranfer.newBuilder()
                .setId(this.id)
                .setActivationKey(this.activationKey)
                .setKeyExpires(this.keyExpires.getTime())
                .build();
    }
}
