package com.jorgito.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jorgito.demo.modelo.Usuario;

@Controller
public class PubliController {

    @GetMapping("/app/publications")
    public String mostrarMenu(
        Model model,
        @SessionAttribute(name = "usuario", required = false) Usuario usuarioActual){

        model.addAttribute("usuarioActual", usuarioActual);

        return  "publications";

    }

}
