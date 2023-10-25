package com.example.webfluxtest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FileExam {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\resources\\using_example.txt");

        Flux.using(() -> Files.lines(path), Flux::fromStream, Stream::close)
                // 읽어올 리소스, 읽어온 resource를 emit하는 flux, 종료시그널 이후 후처리
                .subscribe(log::info);
    }
}
