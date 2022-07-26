package com.sportsapp.sportstrackingapp.controllers;

import com.sportsapp.sportstrackingapp.models.Comment;
import com.sportsapp.sportstrackingapp.services.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    public ResponseEntity<Object> addComment(@Valid @RequestBody Comment comment) {
        commentService.addComment(comment);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/comments")
    public Collection<Comment> retrieveAllComments() {
        return commentService.getComments();
    }
}
