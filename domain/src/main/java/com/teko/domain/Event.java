package com.teko.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "event")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "event_type")
    private String eventType;
    private String status;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "start_time")
    private Time startTime;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "end_time")
    private Date endTime;
    @Column(length = 512)
    private String description;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "disabled")
    private boolean disabled;
    private Date dateOfMeeting;
}
