package com.example.domain.dto;

import com.example.domain.Reminder;

import javax.persistence.Column;

public class ReminderInput implements Input<Reminder> {

    private String reminderType;
    private Integer reminderTime;

    @Override
    public Reminder mapper() {
        return Reminder.builder()
                .reminderTime(this.reminderTime)
                .reminderType(this.reminderType)
                .build();
    }
}
