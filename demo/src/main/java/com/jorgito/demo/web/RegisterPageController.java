package com.jorgito.demo.web;

import org.springframework.stereotype.Controller;
import com.jorgito.demo.servicios.JorgitoException;
import com.jorgito.demo.servicios.SistemaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterPageController {

    @Autowired
    SistemaServices sistema;

    // GET para obtener una página
    // muestra el formulario
    @GetMapping("/app/register")
    public String mostrarPagina(Model model) {

        model.addAttribute("registerForm", new RegisterFormDTO());
        return "register.html";
    }

    // procesa el formulario
    @PostMapping("/app/register")
    public String procesarFormulario (
        @ModelAttribute(name = "registerForm") RegisterFormDTO registerForm,
        Model model) 
        throws JorgitoException{

        // saca los datos del formulario
        System.out.println(registerForm.getNombre());
        System.out.println(registerForm.getEdad());
        System.out.println(registerForm.getEmail());
        System.out.println(registerForm.getPassword());

        // llama a la logica de negocio
        boolean resultado = false;
        String email = registerForm.getEmail();
        String passwd = registerForm.getPassword();
        int edad = registerForm.getEdad();
        String nombre = registerForm.getNombre();
        
        resultado = sistema.registrarse(nombre, edad, email, passwd);

        model.addAttribute("registerForm", registerForm);

        if (resultado == true)
            return "login.html";
        else 
            return "register.html";
    }

}
