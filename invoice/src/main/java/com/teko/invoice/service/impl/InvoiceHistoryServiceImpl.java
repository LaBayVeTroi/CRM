package com.teko.invoice.service.impl;

import com.teko.domain.InvoiceHistory;
import com.teko.proto.*;
import com.teko.repository.InvoiceHistoryRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class InvoiceHistoryServiceImpl extends InvoiceHistoryServiceGrpc.InvoiceHistoryServiceImplBase {

    @Autowired
    private InvoiceHistoryRepository invoiceHistoryRepository;

    @Override
    public void getAll(GetAllInvoiceHistoryRequest request, StreamObserver<InvoiceHistoryTranfer> responseObserver) {
        List<InvoiceHistory> invoiceHistorys = invoiceHistoryRepository.findAll();
        invoiceHistorys.forEach(invoiceHistory -> {
            responseObserver.onNext(invoiceHistory.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetInvoiceHistoryByIdRequest request, StreamObserver<InvoiceHistoryTranfer> responseObserver) {
        Optional<InvoiceHistory> invoiceHistory = invoiceHistoryRepository.findById(request.getId());
        invoiceHistory.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteInvoiceHistoryByIdRequest request, StreamObserver<Empty> responseObserver) {
        invoiceHistoryRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddInvoiceHistoryRequest request, StreamObserver<InvoiceHistoryTranfer> responseObserver) {
        InvoiceHistory invoiceHistory = InvoiceHistory.fromProto(request.getInvoiceHistory());
        InvoiceHistory response = invoiceHistoryRepository.save(invoiceHistory);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateInvoiceHistoryRequest request, StreamObserver<InvoiceHistoryTranfer> responseObserver) {
        InvoiceHistory invoiceHistory = InvoiceHistory.fromProto(request.getInvoiceHistory());
        InvoiceHistory response = invoiceHistoryRepository.saveAndFlush(invoiceHistory);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
