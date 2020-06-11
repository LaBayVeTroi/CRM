package com.teko.domain;

import com.teko.proto.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "planner_event")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlannerEvent {
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
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "object_id")
    private Integer objectId;
    private String parent;
    private String status;
    private String direction;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "close_date")
    private Date closeDate;
    private Integer duration;
    @ManyToMany
    @JoinTable(name = "planner_event_reminder", joinColumns = @JoinColumn(name = "planner_event_id"), inverseJoinColumns = @JoinColumn(name = "reminder_id"))
    private List<Reminder> reminders;
    private String priority;
    @Column(name = "updated_on")
    private Date updatedOn;
    @OneToOne
    @JoinColumn(name = "updated_by")
    private User updatedBy;
    @ManyToMany
    @JoinTable(name = "planner_event_attendees_user", joinColumns = @JoinColumn(name = "planner_event_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> attendeesUser;
    @ManyToMany
    @JoinTable(name = "planner_event_attendees_contact", joinColumns = @JoinColumn(name = "planner_event_id"), inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private List<Contact> attendeesContact;
    @ManyToMany
    @JoinTable(name = "planner_event_attendees_lead", joinColumns = @JoinColumn(name = "planner_event_id"), inverseJoinColumns = @JoinColumn(name = "lead_id"))
    private List<Lead> attendeesLead;
    @Column(name = "created_on")
    private Date createdOn;
    @OneToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    @ManyToMany
    @JoinTable(name = "planner_event_assigned_to", joinColumns = @JoinColumn(name = "planner_event_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> assignedTo;
    private String description;
    @Column(name = "is_active")
    private Boolean isActive;

    public static PlannerEvent fromProto(PlannerEventTranfer plannerEventTranfer) {
        List<Reminder> reminders = new ArrayList<>();
        plannerEventTranfer.getRemindersList().forEach(reminderTranfer -> {
            reminders.add(Reminder.fromProto(reminderTranfer));
        });
        List<User> attendeesUser = new ArrayList<>();
        plannerEventTranfer.getAttendeesUserList().forEach(userTranfer -> {
            attendeesUser.add(User.fromProto(userTranfer));
        });
        List<Contact> attendeesContact = new ArrayList<>();
        plannerEventTranfer.getAttendeesContactList().forEach(contactTranfer -> {
            attendeesContact.add(Contact.fromProto(contactTranfer));
        });
        List<Lead> attendeesLead = new ArrayList<>();
        plannerEventTranfer.getAttendeesLeadList().forEach(leadTranfer -> {
            attendeesLead.add(Lead.fromProto(leadTranfer));
        });
        List<User> assignedTo = new ArrayList<>();
        plannerEventTranfer.getAssignedToList().forEach(userTranfer -> {
            assignedTo.add(User.fromProto(userTranfer));
        });
        return PlannerEvent.builder()
                .id(plannerEventTranfer.getId())
                .name(plannerEventTranfer.getName())
                .eventType(plannerEventTranfer.getEventType())
                .contentType(plannerEventTranfer.getContentType())
                .objectId(plannerEventTranfer.getObjectId())
                .parent(plannerEventTranfer.getParent())
                .status(plannerEventTranfer.getStatus())
                .direction(plannerEventTranfer.getDirection())
                .startDate(new Date(plannerEventTranfer.getStartDate()))
                .closeDate(new Date(plannerEventTranfer.getCloseDate()))
                .duration(plannerEventTranfer.getDuration())
                .reminders(reminders)
                .priority(plannerEventTranfer.getPriority())
                .updatedOn(new Date(plannerEventTranfer.getUpdatedOn()))
                .updatedBy(User.fromProto(plannerEventTranfer.getUpdatedBy()))
                .attendeesUser(attendeesUser)
                .attendeesContact(attendeesContact)
                .attendeesLead(attendeesLead)
                .createdOn(new Date(plannerEventTranfer.getCreatedOn()))
                .createdBy(User.fromProto(plannerEventTranfer.getCreatedBy()))
                .assignedTo(assignedTo)
                .description(plannerEventTranfer.getDescription())
                .isActive(plannerEventTranfer.getIsActive())
                .build();
    }

    public PlannerEventTranfer toProto() {
        PlannerEventTranfer.Builder builder = PlannerEventTranfer.newBuilder();
        for (int i = 0; i < this.reminders.size(); i++) {
            builder.setReminders(i, this.reminders.get(i).toProto());
        }
        for (int i = 0; i < this.attendeesUser.size(); i++) {
            builder.setAttendeesUser(i, this.attendeesUser.get(i).toProto());
        }
        for (int i = 0; i < this.attendeesLead.size(); i++) {
            builder.setAttendeesLead(i, this.attendeesLead.get(i).toProto());
        }
        for (int i = 0; i < this.attendeesContact.size(); i++) {
            builder.setAttendeesContact(i, this.attendeesContact.get(i).toProto());
        }
        for (int i = 0; this.assignedTo.size() > i; i++) {
            builder.setAssignedTo(i, this.assignedTo.get(i).toProto());
        }
        builder.setId(this.id)
                .setName(this.name)
                .setEventType(this.eventType)
                .setContentType(this.contentType)
                .setObjectId(this.objectId)
                .setParent(this.parent)
                .setStatus(this.status)
                .setDirection(this.direction)
                .setStartDate(this.startDate.getTime())
                .setCloseDate(this.closeDate.getTime())
                .setDuration(this.duration)
                .setPriority(this.priority)
                .setUpdatedOn(this.updatedOn.getTime())
                .setUpdatedBy(this.updatedBy.toProto())
                .setCreatedOn(this.createdOn.getTime())
                .setCreatedBy(this.createdBy.toProto())
                .setDescription(this.description)
                .setIsActive(this.isActive);
        return builder.build();
    }
}
