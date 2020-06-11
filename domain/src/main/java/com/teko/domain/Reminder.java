package com.teko.domain;

import com.teko.proto.ReminderTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "reminder")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reminder {
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
    @Column(name = "reminder_type")
    private String reminderType;
    @Column(name = "reminder_time")
    private Integer reminderTime;

    public static Reminder fromProto(ReminderTranfer reminderTranfer) {
        return Reminder.builder()
                .id(reminderTranfer.getId())
                .reminderType(reminderTranfer.getReminderType())
                .reminderTime(reminderTranfer.getReminderTime())
                .build();
    }

    public ReminderTranfer toProto() {
        return ReminderTranfer.newBuilder()
                .setId(this.id)
                .setReminderTime(this.reminderTime)
                .setReminderType(this.reminderType)
                .build();
    }
}
