package com.teko.planner.service.impl;

import com.teko.domain.Event;
import com.teko.proto.*;
import com.teko.repository.EventRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class EventServiceImpl extends EventServiceGrpc.EventServiceImplBase {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void getAll(GetAllEventRequest request, StreamObserver<EventTranfer> responseObserver) {
        List<Event> events = eventRepository.findAll();
        events.forEach(event -> {
            responseObserver.onNext(event.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetEventByIdRequest request, StreamObserver<EventTranfer> responseObserver) {
        Optional<Event> event = eventRepository.findById(request.getId());
        event.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteEventByIdRequest request, StreamObserver<Empty> responseObserver) {
        eventRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddEventRequest request, StreamObserver<EventTranfer> responseObserver) {
        Event event = Event.fromProto(request.getEvent());
        Event response = eventRepository.save(event);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateEventRequest request, StreamObserver<EventTranfer> responseObserver) {
        Event event = Event.fromProto(request.getEvent());
        Event response = eventRepository.saveAndFlush(event);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
