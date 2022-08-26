package com.example.beginner.controller;

import com.example.beginner.dto.PostRequestDto;
import com.example.beginner.dto.PostUpdateDto;
import com.example.beginner.dto.ResponseDto;
import com.example.beginner.dto.passwordDto;
import com.example.beginner.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

  private final PostService postService;

  @PostMapping("/api/post")
  public ResponseDto<?> createPost(@RequestBody PostRequestDto requestDto) {
    return postService.createPost(requestDto);
  }

  @GetMapping("/api/post/{id}")
  public ResponseDto<?> getPost(@PathVariable Long id) {
    return postService.getPost(id);
  }

  @GetMapping("/api/post")
  public ResponseDto<?> getAllPosts() {
    return postService.getAllPost();
  }

  @PutMapping("/api/post/{id}")
  public ResponseDto<?> updatePost(@PathVariable Long id, @RequestBody PostUpdateDto postUpdateDto) {
    return postService.updatePost(id, postUpdateDto);
  }

  @DeleteMapping("/api/post/{id}")
  public ResponseDto<?> deletePost(@PathVariable Long id) {
    return postService.deletePost(id);
  }

  @PostMapping("/api/post/{id}")
  public ResponseDto<?> validateAuthorByPassword(@PathVariable Long id, @RequestBody passwordDto password) {
    return postService.validateAuthorByPassword(id, password);
  }


}
