package com.example.opportynity.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "opportunity")
@Data
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
    private Date closedOn;
    @Column(length = 512)
    private String description;
    private Date createdOn;
    private boolean inActive;
}
