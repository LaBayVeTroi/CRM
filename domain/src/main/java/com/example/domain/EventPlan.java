package com.example.domain;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "event_plan")
@Data
public class EventPlan {
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
    @Column(name = "event_limit")
    private Integer limit;
    private String name;
    private String eventType;
    private Integer objectId;
    @Column(name = "status")
    private String status;
    private String direction;
    private Date startDate;
    private Date closeDate;
    private Integer duration;
    private String priority;
    private Date updateOn;
    private Date createdOn;
    private String description;
    private boolean isActive;
}
