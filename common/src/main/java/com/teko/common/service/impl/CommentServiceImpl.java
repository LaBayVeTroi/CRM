package com.teko.common.service.impl;

import com.teko.domain.Comment;
import com.teko.proto.*;
import com.teko.repository.CommentRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class CommentServiceImpl extends CommentServiceGrpc.CommentServiceImplBase {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void getAll(GetAllCommentRequest request, StreamObserver<CommentTranfer> responseObserver) {
        List<Comment> comments = commentRepository.findAll();
        comments.forEach(comment -> {
            responseObserver.onNext(comment.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetCommentByIdRequest request, StreamObserver<CommentTranfer> responseObserver) {
        Optional<Comment> comment = commentRepository.findById(request.getId());
        comment.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteCommentByIdRequest request, StreamObserver<Empty> responseObserver) {
        commentRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddCommentRequest request, StreamObserver<CommentTranfer> responseObserver) {
        Comment comment = Comment.fromProto(request.getComment());
        Comment response = commentRepository.save(comment);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateCommentRequest request, StreamObserver<CommentTranfer> responseObserver) {
        Comment comment = Comment.fromProto(request.getComment());
        Comment response = commentRepository.saveAndFlush(comment);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
