package com.teko.common.service;

import com.google.protobuf.GeneratedMessageV3;
import io.grpc.stub.StreamObserver;

public interface BaseService {
    void getAll(GeneratedMessageV3 request, StreamObserver<GeneratedMessageV3> response);

}
