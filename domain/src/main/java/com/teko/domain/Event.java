package com.teko.domain;

import com.teko.proto.EventTranfer;
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

    public static Event fromProto(EventTranfer eventTranfer){
        return Event.builder()
                .id(eventTranfer.getId())
                .name(eventTranfer.getName())
                .eventType(eventTranfer.getEventType())
                .status(eventTranfer.getStatus())
                .startDate(new Date(eventTranfer.getStartDate()))
                .endDate(new Date(eventTranfer.getEndDate()))
                .endTime(new Date(eventTranfer.getEndTime()))
                .description(eventTranfer.getDescription())
                .createdOn(new Date(eventTranfer.getCreatedOn()))
                .isActive(eventTranfer.getIsActive())
                .disabled(eventTranfer.getDisabled())
                .dateOfMeeting(new Date(eventTranfer.getDateOfMeeting()))
                .build();

    }

    public EventTranfer toProto(){
        return EventTranfer.newBuilder()
                .setId(this.id)
                .setName(this.name)
                .setEventType(this.eventType)
                .setStatus(this.status)
                .setStartDate(this.startDate.getTime())
                .setEndDate(this.endDate.getTime())
                .setEndTime(this.endTime.getTime())
                .setDescription(this.description)
                .setCreatedOn(this.createdOn.getTime())
                .setIsActive(this.isActive)
                .setDisabled(this.disabled)
                .setDateOfMeeting(this.dateOfMeeting.getTime())
                .build();
    }
}
