package com.example.webfluxtest;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Scheduler {

    public Flux<Integer> fluxMapWithSubscribeOn() {
        return Flux.range(1, 10)
                .map(i -> i*2)
                .subscribeOn(Schedulers.boundedElastic())
                .log();
    }

    public Flux<Integer> fluxMapWithPublishOn() {
        return Flux.range(1, 10)
                .map(i -> i+1)
                .log()
                .publishOn(Schedulers.boundedElastic())
                .log()
                .map(i -> i *2);
    }
}
