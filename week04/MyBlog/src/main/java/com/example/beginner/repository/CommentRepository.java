package com.example.beginner.repository;

import com.example.beginner.entity.Comment;
import com.example.beginner.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByCommentIdOrderByModifiedAtDesc(Long blogId);

    List<Comment> findAllByPostId(Long postId);

    Optional<Comment> findByCommentId(Long id);
}
