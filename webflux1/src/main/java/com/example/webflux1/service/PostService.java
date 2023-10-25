package com.example.webflux1.service;

import com.example.webflux1.client.PostClient;
import com.example.webflux1.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PostService {
    // webclient mvc server request
    private final PostClient postClient;

    public Mono<PostResponse> getPostContent(Long id) {
        return postClient.getPost(id);
    }

}
