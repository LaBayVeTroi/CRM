package com.teko.contact.service.impl;

import com.teko.domain.Contact;
import com.teko.proto.*;
import com.teko.repository.ContactRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class ContactServiceImpl extends ContactServiceGrpc.ContactServiceImplBase{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void getAll(GetAllContactRequest request, StreamObserver<ContactTranfer> responseObserver) {
        List<Contact> contacts = contactRepository.findAll();
        contacts.forEach(contact -> {
            responseObserver.onNext(contact.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetContactByIdRequest request, StreamObserver<ContactTranfer> responseObserver) {
        Optional<Contact> contact = contactRepository.findById(request.getId());
        contact.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteContactByIdRequest request, StreamObserver<Empty> responseObserver) {
        contactRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddContactRequest request, StreamObserver<ContactTranfer> responseObserver) {
        Contact contact = Contact.fromProto(request.getContact());
        Contact response = contactRepository.save(contact);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateContactRequest request, StreamObserver<ContactTranfer> responseObserver) {
        Contact contact = Contact.fromProto(request.getContact());
        Contact response = contactRepository.saveAndFlush(contact);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
