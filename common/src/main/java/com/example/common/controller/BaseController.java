package com.example.common.controller;

import com.example.common.service.AddressService;
import com.example.common.service.CommentService;
import com.example.domain.Address;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class BaseController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/rabbitmq/send")
    @ResponseBody
    public String sendMessage() {
        rabbitTemplate.convertAndSend("myQueue", "Hello World !");
        return "success";
    }

}
