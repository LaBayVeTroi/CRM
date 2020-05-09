package com.example.common.service;

import com.example.common.model.Comment;
import com.example.common.model.User;
import com.example.common.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment addNewComment() {
        User user = new User();
//        Account account = new Account();
        Comment comment = Comment.builder()
                .comment("this is a comment")
                .user(user)
                .build();

        return commentRepository.save(comment);
    }
}
