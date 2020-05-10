package com.example.common.controller;

import com.example.common.service.CommentService;
import com.example.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BaseController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/addComment")
    public Comment addComment() {
        return commentService.addNewComment();
    }
}
