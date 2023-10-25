package com.example.webflux1.controller;

import com.example.webflux1.dto.PostResponse;
import com.example.webflux1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public Mono<PostResponse> getPostContent(@PathVariable Long id){
        return postService.getPostContent(id);
    }
}
