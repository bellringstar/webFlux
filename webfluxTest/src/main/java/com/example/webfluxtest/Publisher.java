package com.example.webfluxtest;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Publisher {

    public static void main(String[] args) {
        var publisher = new Publisher();
        publisher.startFlux()
                .subscribe(System.out::println);

        var publisherMono = new Publisher();
        publisherMono.startMono()
                .subscribe(System.out::println);

        publisherMono.startMonoEmpty()
                .subscribe();
    }

    public Flux<Integer> startFlux() {
        return Flux.range(1, 10)
                .log();
    }

    public Flux<String> startFlux2() {
        return Flux.fromIterable(List.of("a", "b", "c", "d")).log();
    }



    public Mono<Integer> startMono() {
        return Mono.just(1)
                .log();
    }

    public Mono<?> startMonoEmpty() {
        return Mono.empty()
                .log();
    }

    public Mono<?> startMonoError() {
        return Mono.error(new Exception("hello reactor"))
                .log();
    }
}
