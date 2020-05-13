package com.example.domain.dto;

import com.example.domain.Event;
import com.example.domain.EventPlan;

import javax.persistence.Column;
import java.sql.Date;

public class EventPlanInput implements Input<EventPlan> {

    private Integer limit;
    private String name;
    private String eventType;
    private Integer objectId;
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

    @Override
    public EventPlan mapper() {
        return EventPlan.builder()
                .closeDate(this.closeDate)
                .createdOn(this.createdOn)
                .description(this.description)
                .direction(this.direction)
                .duration(this.duration)
                .eventType(this.eventType)
                .isActive(this.isActive)
                .limit(this.limit)
                .name(this.name)
                .objectId(this.objectId)
                .priority(this.priority)
                .startDate(this.startDate)
                .status(this.status)
                .updateOn(this.updateOn)
                .build();
    }
}
