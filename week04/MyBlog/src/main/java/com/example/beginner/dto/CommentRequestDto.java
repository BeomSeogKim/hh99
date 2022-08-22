package com.example.beginner.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private Long commentId;
    private String content;
    private String author;
    private Long postId;
}
