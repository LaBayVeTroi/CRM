package com.teko.common.service.impl;

import com.teko.domain.User;
import com.teko.proto.*;
import com.teko.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void getAll(GetAllUserRequest request, StreamObserver<UserTranfer> responseObserver) {
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            responseObserver.onNext(user.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetUserByIdRequest request, StreamObserver<UserTranfer> responseObserver) {
        Optional<User> user = userRepository.findById(request.getId());
        user.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteUserByIdRequest request, StreamObserver<Empty> responseObserver) {
        userRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddUserRequest request, StreamObserver<UserTranfer> responseObserver) {
        User user = User.fromProto(request.getUser());
        User response = userRepository.save(user);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateUserRequest request, StreamObserver<UserTranfer> responseObserver) {
        User user = User.fromProto(request.getUser());
        User response = userRepository.saveAndFlush(user);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
