package com.sparta.week03_homework.controller;


import com.sparta.week03_homework.models.Post;
import com.sparta.week03_homework.models.PostRequestDto;
import com.sparta.week03_homework.repository.PostRepository;
import com.sparta.week03_homework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/api/posts")
    public List<Post> readPost() {
        return postRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime.now().minusDays(1), LocalDateTime.now());
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
        return id;
    }

}
