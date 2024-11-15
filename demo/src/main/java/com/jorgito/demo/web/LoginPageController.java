package com.jorgito.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jorgito.demo.servicios.SistemaServices;

@Controller
public class LoginPageController {

    @Autowired
    SistemaServices sistema;


    // GET para obtener una página
    @GetMapping("/app/login")
    public String mostrarPagina(Model model) {

        String[] nombres = new String[] {
            "uno",
            "dos",
            "tres"
        };

        model.addAttribute("nombre", "Juan");
        model.addAttribute("apellido", "Sin miedo");
        model.addAttribute("numeros", nombres);

        model.addAttribute("loginForm", new LoginFormDTO());

        return "login.html";
    }

    // POST para procesar el formulario
    @PostMapping("/app/login")
    public String procesarFormulario(
        @ModelAttribute(name = "loginForm") LoginFormDTO loginForm,
        Model model) {

        // saca los datos del formulario
        System.out.println(loginForm.getLogin());
        System.out.println(loginForm.getPassword());

        // llama a la logica de negocio
        boolean resultado = false;
        
        //sistema.iniciarSesion(
        //    loginForm.getLogin(), 
        //    loginForm.getPassword());

        model.addAttribute("loginForm", loginForm);

        if (resultado == true)
            return "menu.html";
        else 
            return "login.html";
    }

}
