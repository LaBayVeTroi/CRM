package com.example.common.resolves.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.common.service.CommentService;
import com.example.domain.Comment;
import com.example.domain.dto.CommentInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentMutation implements GraphQLMutationResolver {
    @Autowired
    private CommentService commentService;

    public Comment createComment(CommentInput commentInput) {
        return commentService.save(commentInput.mapper());
    }

    public List<Comment> createListComment(List<CommentInput> commentInputList) {
        List<Comment> comments = new ArrayList<>();
        commentInputList.forEach(commentInput -> comments.add(commentInput.mapper()));
        return commentService.saveAll(comments);
    }

    public void deleteCommentById(Integer id) {
        commentService.deleteById(id);
    }

    public void deleteAllComment(List<Integer> ids) {
        ids.forEach(this::deleteCommentById);
    }

    public Comment updateComment(Integer id, CommentInput commentInput) {
        Comment comment = commentInput.mapper();
        comment.setId(id);
        return commentService.update(comment);
    }
}
