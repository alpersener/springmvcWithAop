package com.project.crudwithaop.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String loginPage(){
        return "students/loginpage";
    }

    @GetMapping("/access-denied")
    public String accessDeniedPage(){
        return "students/access-denied";
    }
}
