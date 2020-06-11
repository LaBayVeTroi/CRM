package com.teko.invoice.service.impl;

import com.teko.domain.Invoice;
import com.teko.proto.*;
import com.teko.repository.InvoiceRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class InvoiceServiceImpl extends InvoiceServiceGrpc.InvoiceServiceImplBase {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public void getAll(GetAllInvoiceRequest request, StreamObserver<InvoiceTranfer> responseObserver) {
        List<Invoice> invoices = invoiceRepository.findAll();
        invoices.forEach(invoice -> {
            responseObserver.onNext(invoice.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetInvoiceByIdRequest request, StreamObserver<InvoiceTranfer> responseObserver) {
        Optional<Invoice> invoice = invoiceRepository.findById(request.getId());
        invoice.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteInvoiceByIdRequest request, StreamObserver<Empty> responseObserver) {
        invoiceRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddInvoiceRequest request, StreamObserver<InvoiceTranfer> responseObserver) {
        Invoice invoice = Invoice.fromProto(request.getInvoice());
        Invoice response = invoiceRepository.save(invoice);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateInvoiceRequest request, StreamObserver<InvoiceTranfer> responseObserver) {
        Invoice invoice = Invoice.fromProto(request.getInvoice());
        Invoice response = invoiceRepository.saveAndFlush(invoice);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
