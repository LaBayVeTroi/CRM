package com.teko.account.service.impl;

import com.teko.domain.AccountEmail;
import com.teko.proto.*;
import com.teko.repository.AccountEmailRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class AccountEmailServiceImpl extends AccountEmailServiceGrpc.AccountEmailServiceImplBase {

    @Autowired
    private AccountEmailRepository accountEmailRepository;

    @Override
    public void getAll(GetAllAccountEmailRequest request, StreamObserver<AccountEmailTranfer> responseObserver) {
        List<AccountEmail> accountEmails = accountEmailRepository.findAll();
        accountEmails.forEach(accountEmail -> {
            responseObserver.onNext(accountEmail.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetAccountEmailByIdRequest request, StreamObserver<AccountEmailTranfer> responseObserver) {
        Optional<AccountEmail> accountEmail = accountEmailRepository.findById(request.getId());
        accountEmail.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteAccountEmailByIdRequest request, StreamObserver<Empty> responseObserver) {
        accountEmailRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddAccountEmailRequest request, StreamObserver<AccountEmailTranfer> responseObserver) {
        AccountEmail accountEmail = AccountEmail.fromProto(request.getAccountEmail());
        AccountEmail response = accountEmailRepository.save(accountEmail);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateAccountEmailRequest request, StreamObserver<AccountEmailTranfer> responseObserver) {
        AccountEmail accountEmail = AccountEmail.fromProto(request.getAccountEmail());
        AccountEmail response = accountEmailRepository.saveAndFlush(accountEmail);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
