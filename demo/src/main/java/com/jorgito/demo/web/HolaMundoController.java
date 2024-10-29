package com.jorgito.demo.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HolaMundoController {

    @GetMapping("/saludo")
    public String saludar() {
        return "Hola Mundo !!";
    }

}
