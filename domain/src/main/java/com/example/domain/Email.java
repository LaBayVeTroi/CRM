package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "email")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Email {
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
    @Column(name = "from_email")
    private String fromEmail;
    @Column(name = "to_email")
    private String toEmail;
    private String subject;
    private String message;
    private String file;
    @Column(name = "send_time")
    private Date sendTime;
    private String status;
    private boolean important;

}
