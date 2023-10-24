package com.example.webfluxtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class Operator2Test {

    private Operator2 operator2 = new Operator2();

    @Test
    void fluxConcatMap() {
        StepVerifier.create(operator2.fluxConcatMap())
                .expectNextCount(100)
                .verifyComplete();
    }

    @Test
    void monoFlatMapMany() {
        StepVerifier.create(operator2.monoFlatMapMany())
                .expectNextCount(10)
                .verifyComplete();
    }

    @Test
    void defaultIfEmpty1() {
        StepVerifier.create(operator2.defaultIfEmpty1())
                .expectNext(30)
                .verifyComplete();
    }

    @Test
    void defaultIfSwitch1() {
        StepVerifier.create(operator2.defaultIfSwitch1())
                .expectNext(20)
                .verifyComplete();
    }

    @Test
    void defaultSwitch2() {
        StepVerifier.create(operator2.defaultSwitch2())
                .expectError(Exception.class)
                .verify();
    }

    @Test
    void fluxMerge() {
        StepVerifier.create(operator2.fluxMerge())
                .expectNext("1", "2", "3", "4")
                .verifyComplete();
    }

    @Test
    void monoMerge() {
        StepVerifier.create(operator2.monoMerge())
                .expectNext("1", "2", "3")
                .verifyComplete();
    }

    @Test
    void fluxZip() {
        StepVerifier.create(operator2.fluxZip())
                .expectNext("ad", "be", "cf")
                .verifyComplete();
    }

    @Test
    void monoZip() {
        StepVerifier.create(operator2.monoZip())
                .expectNext(6)
                .verifyComplete();
    }
}