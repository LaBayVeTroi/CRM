package com.example.event.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "event")
@Data
public class Event {
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
    private String eventType;
    private String status;
    private Date startDate;
    private Time startTime;
    private Date endDate;
    private Date endTime;
    @Column(length = 512)
    private String description;
    private Date createdOn;
    private boolean isActive;
    private boolean disabled;
    private Date dateOfMeeting;
}
