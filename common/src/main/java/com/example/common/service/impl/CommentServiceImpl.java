package com.example.common.service.impl;

import com.example.common.service.CommentService;
import com.example.domain.Comment;
import com.example.repository.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends BaseServiceImpl<CommentRepository, Comment, Integer> implements CommentService {

    public CommentServiceImpl() {
        super(CommentRepository.class, Comment.class, Integer.class);
    }

    @Autowired
    private CommentRepository commentRepository;

    public Comment addNewComment(){
        Comment comment = new Comment();
        return commentRepository.save(comment);
    }
}
