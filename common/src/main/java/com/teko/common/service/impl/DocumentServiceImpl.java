package com.teko.common.service.impl;

import com.teko.domain.Document;
import com.teko.proto.*;
import com.teko.repository.DocumentRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class DocumentServiceImpl extends DocumentServiceGrpc.DocumentServiceImplBase {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public void getAll(GetAllDocumentRequest request, StreamObserver<DocumentTranfer> responseObserver) {
        List<Document> documents = documentRepository.findAll();
        documents.forEach(document -> {
            responseObserver.onNext(document.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetDocumentByIdRequest request, StreamObserver<DocumentTranfer> responseObserver) {
        Optional<Document> document = documentRepository.findById(request.getId());
        document.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteDocumentByIdRequest request, StreamObserver<Empty> responseObserver) {
        documentRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddDocumentRequest request, StreamObserver<DocumentTranfer> responseObserver) {
        Document document = Document.fromProto(request.getDocument());
        Document response = documentRepository.save(document);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateDocumentRequest request, StreamObserver<DocumentTranfer> responseObserver) {
        Document document = Document.fromProto(request.getDocument());
        Document response = documentRepository.saveAndFlush(document);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
