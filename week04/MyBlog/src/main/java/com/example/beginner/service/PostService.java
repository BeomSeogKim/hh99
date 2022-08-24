package com.example.beginner.service;

import com.example.beginner.dto.PostRequestDto;
import com.example.beginner.dto.PostUpdateDto;
import com.example.beginner.dto.ResponseDto;
import com.example.beginner.dto.passwordDto;
import com.example.beginner.entity.Post;
import com.example.beginner.repository.CommentRepository;
import com.example.beginner.repository.PostRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Service
public class PostService {

  private final PostRepository postRepository;
  private final CommentRepository commentRepository;

  @Transactional
  public ResponseDto<?> createPost(PostRequestDto requestDto) {

    Post post = new Post(requestDto);

    postRepository.save(post);

    return ResponseDto.success(post);
  }

  @Transactional(readOnly = true)
  public ResponseDto<?> getPost(Long id) {
    Optional<Post> optionalPost = postRepository.findById(id);

    if (optionalPost.isEmpty()) {
      return ResponseDto.fail("NULL_POST_ID", "post id isn't exist");
    }

    return ResponseDto.success(optionalPost.get());
  }

  @Transactional(readOnly = true)
  public ResponseDto<?> getAllPost() {
//    ModelAndView mv = new ModelAndView();
//    post = postRepository.findAllByOrderByModifiedAtDesc();
    System.out.println(postRepository.findAll().size()); ;
    ModelAndView mv = new ModelAndView();
    for (int i = 0; i < postRepository.findAll().size(); i++) {

    }
    return ResponseDto.success(postRepository.findAllByOrderByModifiedAtDesc());
  }

  @Transactional
  public ResponseDto<Post> updatePost(Long id, PostUpdateDto updateDto) {
    Optional<Post> optionalPost = postRepository.findById(id);

    if (optionalPost.isEmpty()) {
      return ResponseDto.fail("NULL_POST_ID", "post id isn't exist");
    }

    Post post = optionalPost.get();
    post.update(updateDto);

    return ResponseDto.success(post);
  }

  @Transactional
  public ResponseDto<?> deletePost(Long id) {
    Optional<Post> optionalPost = postRepository.findById(id);

    if (optionalPost.isEmpty()) {
      return ResponseDto.fail("NOT_FOUND", "post id is not exist");
    }

    Post post = optionalPost.get();
//    if (optionalPost.get().getPassword())
    postRepository.delete(post);

    return ResponseDto.success("delete Success");
  }

  @Transactional(readOnly = true)
  public ResponseDto<?> validateAuthorByPassword(Long id, passwordDto password) {
    Optional<Post> optionalPost = postRepository.findById(id);

    if (optionalPost.isEmpty()) {
      return ResponseDto.fail("NOT_FOUND", "post id is not exist");
    }

    Post post = optionalPost.get();

    if (!post.getPassword().equals(password.getPassword())) {
      return ResponseDto.fail("PASSWORD_NOT_CORRECT", "password is not correct");
    }

    return ResponseDto.success(true);
  }


}
