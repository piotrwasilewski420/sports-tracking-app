package com.sportsapp.sportstrackingapp.services;

import com.sportsapp.sportstrackingapp.models.Comment;
import com.sportsapp.sportstrackingapp.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public Collection<Comment> getComments() {
        return commentRepository.findAll();
    }
}
