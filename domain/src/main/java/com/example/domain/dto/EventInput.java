package com.example.domain.dto;

import com.example.domain.Event;

import javax.persistence.Column;
import java.sql.Date;
import java.sql.Time;

public class EventInput implements Input<Event> {

    private Integer id;
    private String name;
    private String eventType;
    private String status;
    private Date startDate;
    private Time startTime;
    private Date endDate;
    private Date endTime;
    private String description;
    private Date createdOn;
    private boolean isActive;
    private boolean disabled;
    private Date dateOfMeeting;

    @Override
    public Event mapper() {
        return Event.builder()
                .createdOn(this.createdOn)
                .dateOfMeeting(this.dateOfMeeting)
                .description(this.description)
                .disabled(this.disabled)
                .endDate(this.endDate)
                .endTime(this.endTime)
                .eventType(this.eventType)
                .isActive(this.isActive)
                .name(this.name)
                .startDate(this.startDate)
                .startTime(this.startTime)
                .status(this.status)
                .build();
    }
}
