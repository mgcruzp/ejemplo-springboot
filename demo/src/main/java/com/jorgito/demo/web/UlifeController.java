package com.jorgito.demo.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UlifeController {


    @GetMapping("/")
    public String index() {
        return "index"; 
    }


    @GetMapping("/home")
    public String home() {
        return "home"; // Nombre del archivo HTML (home.html)
    }

    @GetMapping("/communities")
    public String communities(){
        return "communities"; // Nombre del archivo HTML (communities.html)
    }

    @GetMapping("/login")
    public String login(){
        return "login"; // Nombre del archivo HTML (login.html)
    }

    @GetMapping("/publications")
    public String publications(){
        return "publications"; // Nombre del archivo HTML (publications.html)
    }

    @GetMapping("/register")
    public String register(){
        return "register"; // Nombre del archivo HTML (register.html)
    }

    @GetMapping("/settings")
    public String settings(){
        return "settings"; // Nombre del archivo HTML (settings.html)
    }
}
