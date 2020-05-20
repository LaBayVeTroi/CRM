package com.teko.client.config;

import com.teko.proto.EmailServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfiguration {
    final String ENDPOINT = "localhost:9090";

    @Bean
    Channel channel(){
        return ManagedChannelBuilder
                .forTarget(ENDPOINT)
                .usePlaintext()
                .build();
    }

    @Bean
    EmailServiceGrpc.EmailServiceBlockingStub emailServiceBlockingStub(Channel channel) {
        return EmailServiceGrpc.newBlockingStub(channel);
    }
}
