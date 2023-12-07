package com.example.springmodels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/home/authors")
    public String authors() {
        return "author-list";
    }

    @GetMapping("/home/genres")
    public String genres() {
        return "genres";
    }

    @GetMapping("/home/books")
    public String books() {
        return "books";
    }

    @GetMapping("/home/Color")
    public String Color() {
        return "Color";
    }

    @GetMapping("/home/Price")
    public String Price() {
        return "Price";
    }

    @GetMapping("/home/Style")
    public String Style() {
        return "Style";
    }
    @GetMapping("/home/users")
    public String users() {
        return "users";
    }

}
