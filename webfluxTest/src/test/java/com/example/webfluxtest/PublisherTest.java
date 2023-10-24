package com.example.webfluxtest;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class PublisherTest {

    private Publisher publisher = new Publisher();

    @Test
    void startFlux() {
        StepVerifier.create(publisher.startFlux())
                .expectNext(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .verifyComplete();
    }

    @Test
    void startFlux2() {
        StepVerifier.create(publisher.startFlux2())
                .expectNext("a", "b", "c", "d")
                .verifyComplete();
    }

    @Test
    void startMono() {
        StepVerifier.create(publisher.startMono())
                .expectNext(1)
                .verifyComplete();
    }

    @Test
    void startMonoEmpty() {
        StepVerifier.create(publisher.startMonoEmpty())
                .verifyComplete();
    }

    @Test
    void startMonoError() {
        StepVerifier.create(publisher.startMonoError())
                .expectError(Exception.class)
                .verify();
    }
}