package com.example.webfluxtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class Operator4Test {

    private Operator4 operator4 = new Operator4();

    @Test
    void fluxDelayAndLimitTest() {
        StepVerifier.create(operator4.fluxDelayAndLimit())
                .expectNext(1,2,3,4,5,6,7,8,9,10)
                .verifyComplete();
    }

    @Test
    void fluxSampleTest() {
        StepVerifier.create(operator4.fluxSample())
                .expectNextCount(1000)
                .verifyComplete();
    }

}