package com.teko.account.service.impl;

import com.teko.domain.Tag;
import com.teko.proto.*;
import com.teko.repository.TagRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class TagServiceImpl extends TagServiceGrpc.TagServiceImplBase {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public void getAll(GetAllTagRequest request, StreamObserver<TagTranfer> responseObserver) {
        List<Tag> tags = tagRepository.findAll();
        tags.forEach(tag -> {
            responseObserver.onNext(tag.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetTagByIdRequest request, StreamObserver<TagTranfer> responseObserver) {
        Optional<Tag> tag = tagRepository.findById(request.getId());
        tag.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteTagByIdRequest request, StreamObserver<Empty> responseObserver) {
        tagRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddTagRequest request, StreamObserver<TagTranfer> responseObserver) {
        Tag tag = Tag.fromProto(request.getTag());
        Tag response = tagRepository.save(tag);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateTagRequest request, StreamObserver<TagTranfer> responseObserver) {
        Tag tag = Tag.fromProto(request.getTag());
        Tag response = tagRepository.saveAndFlush(tag);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
