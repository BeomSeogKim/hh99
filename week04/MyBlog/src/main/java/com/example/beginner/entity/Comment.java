package com.example.beginner.entity;


import com.example.beginner.dto.CommentRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private Long postId;

//    @ManyToOne
//    @JoinColumn(name="POST_ID", nullable = false)
//    private Post postId;

    public Comment(CommentRequestDto commentRequestDto) {

        this.commentId = commentRequestDto.getCommentId();
        this.content = commentRequestDto.getContent();
        this.author = commentRequestDto.getAuthor();
        this.postId = commentRequestDto.getPostId();
    }

    public void update(CommentRequestDto commentRequestDto) {
//        this.commentId = commentRequestDto.getCommentId();
        this.content = commentRequestDto.getContent();
//        this.postId = commentRequestDto.getPostId();

    }

}
