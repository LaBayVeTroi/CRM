package com.example.task.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

import static graphql.language.TypeKind.Scalar;

@Entity
@Table(name = "task")
@Data
public class Task  {
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
    private Date dueDate;
    private Date createdOn;
}
