package com.example.beginner.dto;


import com.example.beginner.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostAndCommentDto {
    private String title;
    private String content;
    private String author;
    private String password;
    private Comment comment;
}

