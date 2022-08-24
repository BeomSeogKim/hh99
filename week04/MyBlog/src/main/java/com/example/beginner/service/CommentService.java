package com.example.beginner.service;


import com.example.beginner.dto.CommentRequestDto;
import com.example.beginner.dto.PostRequestDto;
import com.example.beginner.dto.ResponseDto;
import com.example.beginner.entity.Comment;
import com.example.beginner.entity.Post;
import com.example.beginner.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public ResponseDto<?> createComment(CommentRequestDto requestDto) {

        Comment comment = new Comment(requestDto);

        commentRepository.save(comment);

        return ResponseDto.success(comment);
    }

    @Transactional(readOnly = true)
    public ResponseDto<?> getComment(Long id) {
        List<Comment> commentList = commentRepository.findAllByPostId(id);

        if (commentList.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "post id isn't exist");
        }

        return ResponseDto.success(commentList);
    }

    @Transactional
    public ResponseDto<Comment> updateComment(Long id, CommentRequestDto requestDto) {
        Optional<Comment> optionalComment = commentRepository.findByCommentId(id);

        if (optionalComment.isEmpty()) {
            return ResponseDto.fail("NULL_COMMENT_ID", "comment id isn't exist");
        }

        Comment comment = optionalComment.get();
        comment.update(requestDto);

        return ResponseDto.success(comment);
    }

    @Transactional
    public ResponseDto<?> deleteComment(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);

        if (optionalComment.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        }

        Comment comment = optionalComment.get();

        commentRepository.delete(comment);

        return ResponseDto.success("success");
    }

}
