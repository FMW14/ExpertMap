package com.example.ex2.controller;

import com.example.ex2.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Controller
//@RequestMapping("/")
public class MainController {
    @GetMapping("/")
    public String greeting(@AuthenticationPrincipal User user,
                           Model model) {
//        model.addAttribute("user", user);

        return "main";
    }

//    @RequestMapping("/gettime")
//    @ResponseBody
//    public String getSv(){
//        System.out.println("-----get time------");
//        Date d = new Date();
//        return d.toString();
//    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/login")
    public String registration() {
        return "login";
    }
}
