package com.teko.common.service.impl;

import com.teko.domain.CommentFile;
import com.teko.proto.*;
import com.teko.repository.CommentFileRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class CommentFileServiceImpl extends CommentFileServiceGrpc.CommentFileServiceImplBase {

    @Autowired
    private CommentFileRepository commentFileRepository;

    @Override
    public void getAll(GetAllCommentFileRequest request, StreamObserver<CommentFileTranfer> responseObserver) {
        List<CommentFile> commentFiles = commentFileRepository.findAll();
        commentFiles.forEach(commentFile -> {
            responseObserver.onNext(commentFile.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetCommentFileByIdRequest request, StreamObserver<CommentFileTranfer> responseObserver) {
        Optional<CommentFile> commentFile = commentFileRepository.findById(request.getId());
        commentFile.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteCommentFileByIdRequest request, StreamObserver<Empty> responseObserver) {
        commentFileRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddCommentFileRequest request, StreamObserver<CommentFileTranfer> responseObserver) {
        CommentFile commentFile = CommentFile.fromProto(request.getCommentFile());
        CommentFile response = commentFileRepository.save(commentFile);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateCommentFileRequest request, StreamObserver<CommentFileTranfer> responseObserver) {
        CommentFile commentFile = CommentFile.fromProto(request.getCommentFile());
        CommentFile response = commentFileRepository.saveAndFlush(commentFile);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
