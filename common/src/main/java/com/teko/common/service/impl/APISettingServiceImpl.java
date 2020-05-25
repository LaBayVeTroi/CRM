package com.teko.common.service.impl;

import com.teko.domain.APISetting;
import com.teko.proto.*;
import com.teko.repository.ApiSettingRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class APISettingServiceImpl extends APISettingServiceGrpc.APISettingServiceImplBase {

    @Autowired
    private ApiSettingRepository apiSettingRepository;

    @Override
    public void getAll(GetAllAPISettingRequest request, StreamObserver<APISettingTranfer> responseObserver) {
        List<APISetting> apiSettings = apiSettingRepository.findAll();
        apiSettings.forEach(apiSetting -> {
            responseObserver.onNext(apiSetting.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetAPISettingByIdRequest request, StreamObserver<APISettingTranfer> responseObserver) {
        Optional<APISetting> apiSetting = apiSettingRepository.findById(request.getId());
        apiSetting.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteAPISettingByIdRequest request, StreamObserver<Empty> responseObserver) {
        apiSettingRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddAPISettingRequest request, StreamObserver<APISettingTranfer> responseObserver) {
        APISetting apiSetting = APISetting.fromProto(request.getApiSetting());
        APISetting response = apiSettingRepository.save(apiSetting);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateAPISettingRequest request, StreamObserver<APISettingTranfer> responseObserver) {
        APISetting apiSetting = APISetting.fromProto(request.getApiSetting());
        APISetting response = apiSettingRepository.saveAndFlush(apiSetting);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
