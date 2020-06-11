package com.teko.lead.service.impl;

import com.teko.domain.Lead;
import com.teko.proto.*;
import com.teko.repository.LeadRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class LeadServiceImpl extends LeadServiceGrpc.LeadServiceImplBase {

    @Autowired
    private LeadRepository leadRepository;

    @Override
    public void getAll(GetAllLeadRequest request, StreamObserver<LeadTranfer> responseObserver) {
        List<Lead> leads = leadRepository.findAll();
        leads.forEach(lead -> {
            responseObserver.onNext(lead.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetLeadByIdRequest request, StreamObserver<LeadTranfer> responseObserver) {
        Optional<Lead> lead = leadRepository.findById(request.getId());
        lead.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteLeadByIdRequest request, StreamObserver<Empty> responseObserver) {
        leadRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddLeadRequest request, StreamObserver<LeadTranfer> responseObserver) {
        Lead lead = Lead.fromProto(request.getLead());
        Lead response = leadRepository.save(lead);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateLeadRequest request, StreamObserver<LeadTranfer> responseObserver) {
        Lead lead = Lead.fromProto(request.getLead());
        Lead response = leadRepository.saveAndFlush(lead);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
