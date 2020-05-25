package com.teko.planner.service.impl;

import com.teko.domain.Reminder;
import com.teko.proto.*;
import com.teko.repository.ReminderRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class ReminderServiceImpl extends ReminderServiceGrpc.ReminderServiceImplBase {

    @Autowired
    private ReminderRepository reminderRepository;

    @Override
    public void getAll(GetAllReminderRequest request, StreamObserver<ReminderTranfer> responseObserver) {
        List<Reminder> reminders = reminderRepository.findAll();
        reminders.forEach(reminder -> {
            responseObserver.onNext(reminder.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetReminderByIdRequest request, StreamObserver<ReminderTranfer> responseObserver) {
        Optional<Reminder> reminder = reminderRepository.findById(request.getId());
        reminder.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteReminderByIdRequest request, StreamObserver<Empty> responseObserver) {
        reminderRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddReminderRequest request, StreamObserver<ReminderTranfer> responseObserver) {
        Reminder reminder = Reminder.fromProto(request.getReminder());
        Reminder response = reminderRepository.save(reminder);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateReminderRequest request, StreamObserver<ReminderTranfer> responseObserver) {
        Reminder reminder = Reminder.fromProto(request.getReminder());
        Reminder response = reminderRepository.saveAndFlush(reminder);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
