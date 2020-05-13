package com.example.domain.dto;

import com.example.domain.Task;

import java.sql.Date;

public class TaskInput implements Input<Task> {

    private String title;
    private String status;
    private String priority;
    private Date dueDate;
    private Date createdOn;

    @Override
    public Task mapper() {
        return Task.builder()
                .createdOn(this.createdOn)
                .dueDate(this.dueDate)
                .priority(this.priority)
                .status(this.status)
                .title(this.title)
                .build();
    }
}
