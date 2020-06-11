package com.teko.accountEmailLog.service.impl;

import com.teko.domain.AccountEmailLog;
import com.teko.proto.*;
import com.teko.repository.AccountEmailLogRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class AccountEmailLogServiceImpl extends AccountEmailLogServiceGrpc.AccountEmailLogServiceImplBase {

    @Autowired
    private AccountEmailLogRepository accountEmailLogRepository;

    @Override
    public void getAll(GetAllAccountEmailLogRequest request, StreamObserver<AccountEmailLogTranfer> responseObserver) {
        List<AccountEmailLog> accountEmailLogs = accountEmailLogRepository.findAll();
        accountEmailLogs.forEach(accountEmailLog -> responseObserver.onNext(accountEmailLog.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetAccountEmailLogByIdRequest request, StreamObserver<AccountEmailLogTranfer> responseObserver) {
        Optional<AccountEmailLog> accountEmailLog = accountEmailLogRepository.findById(request.getId());
        accountEmailLog.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteAccountEmailLogByIdRequest request, StreamObserver<Empty> responseObserver) {
        accountEmailLogRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddAccountEmailLogRequest request, StreamObserver<AccountEmailLogTranfer> responseObserver) {
        AccountEmailLog accountEmailLog = AccountEmailLog.fromProto(request.getAccountEmailLog());
        AccountEmailLog response = accountEmailLogRepository.save(accountEmailLog);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateAccountEmailLogRequest request, StreamObserver<AccountEmailLogTranfer> responseObserver) {
        AccountEmailLog accountEmailLog = AccountEmailLog.fromProto(request.getAccountEmailLog());
        AccountEmailLog response = accountEmailLogRepository.saveAndFlush(accountEmailLog);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
