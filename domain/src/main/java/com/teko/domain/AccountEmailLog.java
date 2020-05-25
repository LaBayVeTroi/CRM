package com.teko.domain;

import com.teko.proto.AccountEmailLogTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "account_email_log")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountEmailLog {
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
    @Column(name = "is_sent")
    private boolean isSent;

    public static AccountEmailLog fromProto(AccountEmailLogTranfer accountEmailLogTranfer){
        return AccountEmailLog.builder()
                .id(accountEmailLogTranfer.getId())
                .isSent(accountEmailLogTranfer.getIsSent())
                .build();
    }

    public AccountEmailLogTranfer toProto(){
        return AccountEmailLogTranfer.newBuilder()
                .setId(this.id)
                .setIsSent(this.isSent)
                .build();
    }
}
