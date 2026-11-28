package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class Main {

    private final Map<String, Integer> users = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @PostMapping("/users")
    public String addUser(@RequestParam String name,
                          @RequestParam int age) {
        users.put(name, age);
        return "登録しました: " + name + " " + age + "歳";
    }

    @GetMapping("/users")
    public Map<String, Integer> getUsers() {
        return users;
    }
}