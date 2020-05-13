//package com.example.common.resolves.mutations;
//
//import com.coxautodev.graphql.tools.GraphQLMutationResolver;
//import com.example.common.service.CommentService;
//import com.example.domain.Comment;
//import com.example.domain.dto.CommentInput;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CommentMutation implements GraphQLMutationResolver {
//    @Autowired
//    private CommentService commentService;
//
//    public Comment addComment(CommentInput commentInput) {
//        return commentService.save(commentInput.mapper());
//    }
//}
