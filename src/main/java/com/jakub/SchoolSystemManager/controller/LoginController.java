package com.jakub.SchoolSystemManager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class LoginController {

    @GetMapping("/greeting")
    public ModelAndView greeting() {
        System.out.println("Logged in");
        return new ModelAndView("student-interface.html");
    }

    @GetMapping("/login")
    public ModelAndView redirectLogin() {
        System.out.println("There was a login attempt.");
        return new ModelAndView("index.html");
    }

    @GetMapping("/student-interface")
    public ModelAndView studentInterface() {
        System.out.println("Accessing student interface");
        return new ModelAndView("student-interface.html");
    }

}
