package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "opportunity")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Opportunity {
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
    private String stage;
    private String currency;
    private Integer amount;
    private String source;
    private Integer probability;
    @Column(name = "close_on")
    private Date closedOn;
    @Column(length = 512)
    private String description;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "in_active")
    private boolean inActive;
}
