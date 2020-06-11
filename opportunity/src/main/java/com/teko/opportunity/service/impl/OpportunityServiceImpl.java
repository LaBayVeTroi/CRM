package com.teko.opportunity.service.impl;

import com.teko.domain.Opportunity;
import com.teko.proto.*;
import com.teko.repository.OpportunityRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class OpportunityServiceImpl extends OpportunityServiceGrpc.OpportunityServiceImplBase {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Override
    public void getAll(GetAllOpportunityRequest request, StreamObserver<OpportunityTranfer> responseObserver) {
        List<Opportunity> opportunitys = opportunityRepository.findAll();
        opportunitys.forEach(opportunity -> {
            responseObserver.onNext(opportunity.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetOpportunityByIdRequest request, StreamObserver<OpportunityTranfer> responseObserver) {
        Optional<Opportunity> opportunity = opportunityRepository.findById(request.getId());
        opportunity.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteOpportunityByIdRequest request, StreamObserver<Empty> responseObserver) {
        opportunityRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddOpportunityRequest request, StreamObserver<OpportunityTranfer> responseObserver) {
        Opportunity opportunity = Opportunity.fromProto(request.getOpportunity());
        Opportunity response = opportunityRepository.save(opportunity);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateOpportunityRequest request, StreamObserver<OpportunityTranfer> responseObserver) {
        Opportunity opportunity = Opportunity.fromProto(request.getOpportunity());
        Opportunity response = opportunityRepository.saveAndFlush(opportunity);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
