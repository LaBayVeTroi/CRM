package com.example.common.service;

import com.example.domain.Comment;
import com.example.repository.repository.CommentRepository;
import org.springframework.stereotype.Service;

public interface CommentService {
    Comment addNewComment();
}
