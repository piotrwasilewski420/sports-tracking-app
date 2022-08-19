package com.sportsapp.sportstrackingapp.dtos;

import com.sportsapp.sportstrackingapp.models.Comment;
import com.sportsapp.sportstrackingapp.models.Type;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter @Setter @RequiredArgsConstructor
public class ActivityDTO {
    private Long id;
    private Type type;
    private Timestamp date_start;
    private Timestamp date_end;
    private List<Comment> comments;
}
