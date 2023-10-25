package com.example.webflux1.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class UserRepositoryTest {

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Test
    void save() {
        User user = User.builder().name("greg").email("greg@webflux").build();
        StepVerifier.create(userRepository.save(user))
                .assertNext(u -> {
                    assertEquals(1L, u.getId());
                    assertEquals("greg", user.getName());
                    assertEquals("greg@webflux", user.getEmail());
                });
    }

    @Test
    void findAll() {
        userRepository.save(User.builder().name("greg").email("greg@webflux").build());
        userRepository.save(User.builder().name("greg2").email("greg@webflux").build());
        userRepository.save(User.builder().name("greg2").email("greg@webflux").build());

        StepVerifier.create(userRepository.findAll())
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void findById() {
        userRepository.save(User.builder().name("greg").email("greg@webflux").build());
        userRepository.save(User.builder().name("greg2").email("greg@webflux").build());

        StepVerifier.create(userRepository.findById(2L))
                .assertNext(u -> {
                    assertEquals(2L, u.getId());
                    assertEquals("greg2", u.getName());
                    assertEquals("greg@webflux", u.getEmail());
                });
    }

    @Test
    void deletedById() {
        userRepository.save(User.builder().name("greg").email("greg@webflux").build());
        userRepository.save(User.builder().name("greg2").email("greg@webflux").build());

        StepVerifier.create(userRepository.deletedById(2L))
                .expectNextCount(1)
                .verifyComplete();
    }
}