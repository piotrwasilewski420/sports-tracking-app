package com.sportsapp.sportstrackingapp.repositories;

import com.sportsapp.sportstrackingapp.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
