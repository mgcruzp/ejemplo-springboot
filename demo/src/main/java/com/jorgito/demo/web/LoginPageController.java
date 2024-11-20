package com.jorgito.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jorgito.demo.modelo.Usuario;
import com.jorgito.demo.servicios.JorgitoException;
import com.jorgito.demo.servicios.SistemaServices;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("usuarioActual")
public class LoginPageController {


    @Autowired
    SistemaServices sistema;



    // GET para obtener una página
    // muestra la pantalla
    @GetMapping("/app/login")
    public String mostrarPagina(
        Model model,
        @SessionAttribute(name = "usuario", required = false) Usuario usuarioActual
        ) {

        model.addAttribute("loginForm", new LoginFormDTO());
        model.addAttribute("loginActual", usuarioActual != null ? usuarioActual.getNombre() : "Extraño");

        return "login.html";
    }


    // POST para procesar el formulario
    // procesa el formulario
    @PostMapping("/app/login")
    public String procesarFormulario (
            @ModelAttribute(name = "loginForm") LoginFormDTO loginForm,                  // formulario de la pantalla
            Model model,                                                                 // modelo que le vas a pasar a la siguiente pantalla
            @SessionAttribute(name = "usuario", required = false) Usuario usuarioActual, // usuario actual en la sesión
            HttpSession session                                                          // la sesión
            ) 
        throws JorgitoException{

        // saca los datos del formulario
        System.out.println(loginForm.getLogin());
        System.out.println(loginForm.getPassword());

        // llama a la logica de negocio
        String email = loginForm.getLogin();
        String passwd = loginForm.getPassword();

        try {

            Usuario resultado = sistema.inicioSesion(email, passwd);

            // le fue bien -- no se fue a la excepción

            // agregas el usuario a la sesión
            session.setAttribute("usuario", resultado);
    
            // colocas los datos en el modelo
            model.addAttribute("loginForm", loginForm);
            model.addAttribute("loginActual", usuarioActual != null ? usuarioActual.getNombre() : "Extraño");
    
            // muestras home
            return "redirect:/app/index";
            
        } catch (Exception e) {

            // si hay un error
            // muestras login, de nuevo
            return "redirect:/app/login";
        }
    }

}
