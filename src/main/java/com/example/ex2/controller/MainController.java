package com.example.ex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
//@RequestMapping("/")
public class MainController {
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "main";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/login")
    public String registration() {
        return "login";
    }
}
