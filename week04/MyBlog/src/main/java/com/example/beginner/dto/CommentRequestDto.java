package com.example.beginner.dto;


import com.example.beginner.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommentRequestDto {
    private Long commentId;
    private String content;
    private String author;
    private Long postId;
//    private Post postId;

}
