package com.example.webflux1.service;

import com.example.webflux1.repository.User;
import com.example.webflux1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Mono<User> create(String name, String email) {
        return userRepository.save(
                User.builder()
                        .name(name)
                        .email(email)
                        .build()
        );
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<Integer> deleteById(Long id) {
        return userRepository.deletedById(id);
    }

    public Mono<User> update(Long id, String name, String eamil) {
        // 1. 해당 사용자를 찾는다.
        Mono<User> user = userRepository.findById(id);
        // 2. 데이터를 변경하고 저장한다.
        return user.flatMap(u -> { //Map은 Mono를 리턴 즉 Mono<Mono<User>>가 리턴된다.
            u.setName(name);
            u.setEmail(eamil);
            return userRepository.save(u);
        });
    }
}
