package com.teko.task.service.impl;

import com.teko.domain.Task;
import com.teko.proto.*;
import com.teko.repository.TaskRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class TaskServiceImpl extends TaskServiceGrpc.TaskServiceImplBase {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void getAll(GetAllTaskRequest request, StreamObserver<TaskTranfer> responseObserver) {
        List<Task> tasks = taskRepository.findAll();
        tasks.forEach(task -> responseObserver.onNext(task.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetTaskByIdRequest request, StreamObserver<TaskTranfer> responseObserver) {
        Optional<Task> task = taskRepository.findById(request.getId());
        task.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteTaskByIdRequest request, StreamObserver<Empty> responseObserver) {
        taskRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddTaskRequest request, StreamObserver<TaskTranfer> responseObserver) {
        Task task = Task.fromProto(request.getTask());
        Task response = taskRepository.save(task);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateTaskRequest request, StreamObserver<TaskTranfer> responseObserver) {
        Task task = Task.fromProto(request.getTask());
        Task response = taskRepository.saveAndFlush(task);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
