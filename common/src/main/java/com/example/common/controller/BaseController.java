package com.example.common.controller;

import com.example.common.service.CommentService;
import com.example.domain.Comment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class BaseController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/addComment")
    public Comment addComment() {
        return commentService.addNewComment();
    }

    @RequestMapping("/rabbitmq/send")
    @ResponseBody
    public String sendMessage() {
        rabbitTemplate.convertAndSend("myQueue", "Hello World !");
        return "success";
    }

}
