package com.teko.domain;

import com.teko.proto.EventPlanTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "event_plan")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "event_type")
    private String eventType;
    @Column(name = "object_id")
    private Integer objectId;
    @Column(name = "status")
    private String status;
    private String direction;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "close_date")
    private Date closeDate;
    private Integer duration;
    private String priority;
    @Column(name = "update_on")
    private Date updateOn;
    @Column(name = "created_on")
    private Date createdOn;
    private String description;
    @Column(name = "is_active")
    private boolean isActive;

    public static EventPlan fromProto(EventPlanTranfer eventPlanTranfer){
        return EventPlan.builder()
                .id(eventPlanTranfer.getId())
                .limit(eventPlanTranfer.getLimit())
                .name(eventPlanTranfer.getName())
                .eventType(eventPlanTranfer.getEvenType())
                .objectId(eventPlanTranfer.getObjectId())
                .startDate(new Date(eventPlanTranfer.getStartDate()))
                .status(eventPlanTranfer.getStatus())
                .direction(eventPlanTranfer.getDirection())
                .closeDate(new Date(eventPlanTranfer.getCloseDate()))
                .duration(eventPlanTranfer.getDuration())
                .priority(eventPlanTranfer.getPriority())
                .updateOn(new Date(eventPlanTranfer.getUpdateOn()))
                .createdOn(new Date(eventPlanTranfer.getCreatedOn()))
                .description(eventPlanTranfer.getDescription())
                .isActive(eventPlanTranfer.getIsActive())
                .build();
    }

    public EventPlanTranfer toProto(){
        return EventPlanTranfer.newBuilder()
                .setId(this.id)
                .setLimit(this.limit)
                .setName(this.name)
                .setEvenType(this.eventType)
                .setObjectId(this.objectId)
                .setStartDate(this.startDate.getTime())
                .setStatus(this.status)
                .setDirection(this.direction)
                .setCloseDate(this.closeDate.getTime())
                .setDuration(this.duration)
                .setPriority(this.priority)
                .setUpdateOn(this.updateOn.getTime())
                .setCreatedOn(this.createdOn.getTime())
                .setDescription(this.description)
                .setIsActive(this.isActive)
                .build();
    }
}
