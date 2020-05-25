package com.teko.account.service.impl;

import com.teko.domain.Account;
import com.teko.proto.*;
import com.teko.repository.AccountRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class AccountServiceImpl extends AccountServiceGrpc.AccountServiceImplBase {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void getAll(GetAllAccountRequest request, StreamObserver<AccountTranfer> responseObserver) {
        List<Account> accounts = accountRepository.findAll();
        accounts.forEach(account -> {
            responseObserver.onNext(account.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetAccountByIdRequest request, StreamObserver<AccountTranfer> responseObserver) {
        Optional<Account> account = accountRepository.findById(request.getId());
        account.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteAccountByIdRequest request, StreamObserver<Empty> responseObserver) {
        accountRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddAccountRequest request, StreamObserver<AccountTranfer> responseObserver) {
        Account account = Account.fromProto(request.getAccount());
        Account response = accountRepository.save(account);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateAccountRequest request, StreamObserver<AccountTranfer> responseObserver) {
        Account account = Account.fromProto(request.getAccount());
        Account response = accountRepository.saveAndFlush(account);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
