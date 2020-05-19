package com.teko.email.service.Impl;

import com.teko.email.service.EmailService;
import com.teko.proto.*;
import com.teko.repository.EmailRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

@GrpcService
public class EmailServiceImpl extends EmailServiceGrpc.EmailServiceImplBase implements EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Override
    public void getAll(GetAllEmailRequest request, StreamObserver<EmailTranfer> responseObserver) {
        super.getAll(request, responseObserver);
    }

    @Override
    public void getById(GetEmailByIdRequest request, StreamObserver<EmailTranfer> responseObserver) {
        super.getById(request, responseObserver);
    }

    @Override
    public void deleteById(DeleteEmailByIdRequest request, StreamObserver<EmailTranfer> responseObserver) {
        super.deleteById(request, responseObserver);
    }

    @Override
    public void save(AddEmailRequest request, StreamObserver<EmailTranfer> responseObserver) {
        super.save(request, responseObserver);
    }

    @Override
    public void update(UpdateEmailRequest request, StreamObserver<EmailTranfer> responseObserver) {
        super.update(request, responseObserver);
    }
}
