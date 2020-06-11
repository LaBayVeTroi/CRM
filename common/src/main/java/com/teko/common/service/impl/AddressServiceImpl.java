package com.teko.common.service.impl;

import com.teko.domain.Address;
import com.teko.proto.*;
import com.teko.repository.AddressRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.grpc.server.GrpcService;

import java.util.List;
import java.util.Optional;

@GrpcService
public class AddressServiceImpl extends AddressServiceGrpc.AddressServiceImplBase {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void getAll(GetAllAddressRequest request, StreamObserver<AddressTranfer> responseObserver) {
        List<Address> addresss = addressRepository.findAll();
        addresss.forEach(address -> {
            responseObserver.onNext(address.toProto());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getById(GetAddressByIdRequest request, StreamObserver<AddressTranfer> responseObserver) {
        Optional<Address> address = addressRepository.findById(request.getId());
        address.ifPresent(value -> responseObserver.onNext(value.toProto()));
        responseObserver.onCompleted();
    }

    @Override
    public void deleteById(DeleteAddressByIdRequest request, StreamObserver<Empty> responseObserver) {
        addressRepository.deleteById(request.getId());
        responseObserver.onCompleted();
    }

    @Override
    public void save(AddAddressRequest request, StreamObserver<AddressTranfer> responseObserver) {
        Address address = Address.fromProto(request.getAddress());
        Address response = addressRepository.save(address);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }

    @Override
    public void update(UpdateAddressRequest request, StreamObserver<AddressTranfer> responseObserver) {
        Address address = Address.fromProto(request.getAddress());
        Address response = addressRepository.saveAndFlush(address);
        responseObserver.onNext(response.toProto());
        responseObserver.onCompleted();
    }
}
