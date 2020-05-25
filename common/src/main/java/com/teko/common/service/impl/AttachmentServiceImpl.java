package com.teko.common.service.impl;

import com.teko.domain.Attachment;
import com.teko.proto.*;
import com.teko.repository.AttachmentRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class AttachmentServiceImpl extends AttachmentServiceGrpc.AttachmentServiceImplBase {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    public void getAll(GetAllAttachmentRequest request, StreamObserver<AttachmentTranfer> responseObserver) {
        List<Attachment> attachments = attachmentRepository.findAll();
        attachments.forEach(attachment -> {
            responseObserver.onNext(attachment.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetAttachmentByIdRequest request, StreamObserver<AttachmentTranfer> responseObserver) {
        Optional<Attachment> attachment = attachmentRepository.findById(request.getId());
        attachment.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteAttachmentByIdRequest request, StreamObserver<Empty> responseObserver) {
        attachmentRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddAttachmentRequest request, StreamObserver<AttachmentTranfer> responseObserver) {
        Attachment attachment = Attachment.fromProto(request.getAttachment());
        Attachment response = attachmentRepository.save(attachment);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateAttachmentRequest request, StreamObserver<AttachmentTranfer> responseObserver) {
        Attachment attachment = Attachment.fromProto(request.getAttachment());
        Attachment response = attachmentRepository.saveAndFlush(attachment);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
