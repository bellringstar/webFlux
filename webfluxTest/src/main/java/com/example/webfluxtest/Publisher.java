package com.example.webfluxtest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Publisher {

    public Flux<Integer> startFlux() {
        return Flux.range(1,10).log();
    }

    public Mono<Integer> startMono() {
        return Mono.just(1).log();
    }

    public Mono<?> startMonoEmpty() {
        return Mono.empty().log();
    }


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
}
