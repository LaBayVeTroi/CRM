package com.teko.planner.service.impl;

import com.teko.domain.PlannerEvent;
import com.teko.proto.*;
import com.teko.repository.PlannerEventRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class PlannerEventServiceImpl extends PlannerEventServiceGrpc.PlannerEventServiceImplBase {

    @Autowired
    private PlannerEventRepository eventPlannerRepository;

    @Override
    public void getAll(GetAllPlannerEventRequest request, StreamObserver<PlannerEventTranfer> responseObserver) {
        List<PlannerEvent> eventPlanners = eventPlannerRepository.findAll();
        eventPlanners.forEach(eventPlanner -> {
            responseObserver.onNext(eventPlanner.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetPlannerEventByIdRequest request, StreamObserver<PlannerEventTranfer> responseObserver) {
        Optional<PlannerEvent> eventPlanner = eventPlannerRepository.findById(request.getId());
        eventPlanner.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeletePlannerEventByIdRequest request, StreamObserver<Empty> responseObserver) {
        eventPlannerRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddPlannerEventRequest request, StreamObserver<PlannerEventTranfer> responseObserver) {
        PlannerEvent eventPlanner = PlannerEvent.fromProto(request.getPlannerEvent());
        PlannerEvent response = eventPlannerRepository.save(eventPlanner);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdatePlannerEventRequest request, StreamObserver<PlannerEventTranfer> responseObserver) {
        PlannerEvent eventPlanner = PlannerEvent.fromProto(request.getPlannerEvent());
        PlannerEvent response = eventPlannerRepository.saveAndFlush(eventPlanner);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
