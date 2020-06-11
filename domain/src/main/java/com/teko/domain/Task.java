package com.teko.domain;

import com.teko.proto.TaskTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "task")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
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
    private String title;
    private String status;
    private String priority;
    @Column(name = "due_date")
    private Date dueDate;
    @Column(name = "created_on")
    private Date createdOn;

    public static Task fromProto(TaskTranfer taskTranfer) {
        return Task.builder()
                .id(taskTranfer.getId())
                .title(taskTranfer.getTitle())
                .status(taskTranfer.getStatus())
                .priority(taskTranfer.getPriority())
                .dueDate(new Date(taskTranfer.getDueDate()))
                .createdOn(new Date(taskTranfer.getCreatedOn()))
                .build();
    }

    public TaskTranfer toProto() {
        return TaskTranfer.newBuilder()
                .setId(this.id)
                .setTitle(this.title)
                .setStatus(this.status)
                .setPriority(this.priority)
                .setDueDate(this.dueDate.getTime())
                .setCreatedOn(this.createdOn.getTime())
                .build();
    }
}
