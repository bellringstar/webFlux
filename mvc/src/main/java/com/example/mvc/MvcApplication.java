package com.example.mvc;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }

    @GetMapping("/posts/{id}")
    public Map<String, String> getPosts(@PathVariable Long id) throws InterruptedException {
        Thread.sleep(3000);
        return Map.of("id", id.toString(), "content", "Posts content is %d".formatted(id));
    }
}
