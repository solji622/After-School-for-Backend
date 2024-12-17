package com.example.firstproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 뷰 반환하던 맵핑과 다르게 데이터 반환(JSON)
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello World";
    }
}