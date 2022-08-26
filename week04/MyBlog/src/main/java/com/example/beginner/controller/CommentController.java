package com.example.beginner.controller;

import com.example.beginner.dto.CommentRequestDto;
import com.example.beginner.dto.PostRequestDto;
import com.example.beginner.dto.ResponseDto;
import com.example.beginner.entity.Comment;
import com.example.beginner.entity.Post;
import com.example.beginner.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    //댓글 생성
    @PostMapping("/api/auth/comment")
    public ResponseDto<?> createPost(@RequestBody CommentRequestDto requestDto) {


        return commentService.createComment(requestDto);
    }
    //댓글 조회
    @GetMapping("/api/comment/{id}")
    public ResponseDto<?> getallComents(@PathVariable Long id) {

        return commentService.getComment(id);
    }
    //댓글 수정
    @PutMapping("/api/auth/comment/{id}")
    public ResponseDto<?> updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(id, commentRequestDto);
    }

    //댓글 삭제
    @DeleteMapping("/api/auth/comment/{id}")
    public ResponseDto<?> deleteComment(@PathVariable Long id)
    {
        return commentService.deleteComment(id);
    }
}
