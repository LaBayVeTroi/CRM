package com.teko.common.service.impl;

import com.teko.domain.Google;
import com.teko.proto.*;
import com.teko.repository.GoogleRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class GoogleServiceImpl extends GoogleServiceGrpc.GoogleServiceImplBase {

    @Autowired
    private GoogleRepository googleRepository;

    @Override
    public void getAll(GetAllGoogleRequest request, StreamObserver<GoogleTranfer> responseObserver) {
        List<Google> googles = googleRepository.findAll();
        googles.forEach(google -> {
            responseObserver.onNext(google.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetGoogleByIdRequest request, StreamObserver<GoogleTranfer> responseObserver) {
        Optional<Google> google = googleRepository.findById(request.getId());
        google.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteGoogleByIdRequest request, StreamObserver<Empty> responseObserver) {
        googleRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddGoogleRequest request, StreamObserver<GoogleTranfer> responseObserver) {
        Google google = Google.fromProto(request.getGoogle());
        Google response = googleRepository.save(google);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateGoogleRequest request, StreamObserver<GoogleTranfer> responseObserver) {
        Google google = Google.fromProto(request.getGoogle());
        Google response = googleRepository.saveAndFlush(google);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
