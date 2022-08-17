package com.sparta.week03_homework.controller;


import com.sparta.week03_homework.models.Post;
import com.sparta.week03_homework.models.PostRequestDto;
import com.sparta.week03_homework.repository.PostRepository;
import com.sparta.week03_homework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequiredArgsConstructor
@RestController
public class DetailPostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping("api/posts/{id}")
    public Optional<Post> readPost(@PathVariable Long id) {
        return postRepository.findById(id);
    }

    @PostMapping("api/posts/{id}")
    public boolean loginProcess(@PathVariable Long id, @RequestBody PostRequestDto requestDto ) {
        Optional<Post> post = postRepository.findById(id);
//        return post.get().getPassword();
//        return password;
        return post.get().getPassword().equals(requestDto.getPassword());
    }
}


