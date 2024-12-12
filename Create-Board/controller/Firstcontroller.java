package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Firstcontroller {

    @GetMapping("/hi") // 주소창에 hi가 입력되면 메소드 실행
    public String nicetomeetyou(Model model) {
        model.addAttribute("username", "장발장");
        return "greetings";
    }

    @GetMapping("/bye")
    public String goodbye(Model model) {
        model.addAttribute("username", "장발장");
        return "bye";
    }
}
