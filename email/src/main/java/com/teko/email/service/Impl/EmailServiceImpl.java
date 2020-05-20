package com.teko.email.service.Impl;

import com.teko.domain.Email;
import com.teko.email.service.EmailService;
import com.teko.proto.*;
import com.teko.repository.EmailRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class EmailServiceImpl extends EmailServiceGrpc.EmailServiceImplBase implements EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Override
    public void getAll(GetAllEmailRequest request, StreamObserver<EmailTranfer> responseObserver) {
        List<Email> emails = emailRepository.findAll();
        emails.forEach(email -> {
            responseObserver.onNext(email.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetEmailByIdRequest request, StreamObserver<EmailTranfer> responseObserver) {
        Optional<Email> email = emailRepository.findById(request.getId());
        email.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteEmailByIdRequest request, StreamObserver<Empty> responseObserver) {
        emailRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddEmailRequest request, StreamObserver<EmailTranfer> responseObserver) {
        Email email = Email.fromProto(request.getEmail());
        Email response = emailRepository.save(email);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateEmailRequest request, StreamObserver<EmailTranfer> responseObserver) {
        Email email = Email.fromProto(request.getEmail());
        Email response = emailRepository.saveAndFlush(email);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
