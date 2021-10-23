package com.authoritydmc.fullstack.backend.controller;

import com.authoritydmc.fullstack.backend.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String mainPage() {

return "<h1>Welcome to Student api </h1><hr><br> A sample get api on <a href='api/v1/student'>/api/v1/student</a>";

    }
}