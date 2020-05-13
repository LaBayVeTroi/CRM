package com.example.common.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.SimpleBeanInfo;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue myQueue(){
        return new Queue("myQueue",false);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_exchange");
    }
//
//    @Bean
//    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
//
//    }
//
//    @Bean
//    public ConnectionFactory connectionFactory(){
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        connectionFactory.setHost();
//    }


}
