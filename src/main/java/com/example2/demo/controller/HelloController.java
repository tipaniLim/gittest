package com.example2.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {


    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "main@@");
        model.addAttribute("name", "Lim SO Jeong");
        return "hello";
    }
    
    
}
