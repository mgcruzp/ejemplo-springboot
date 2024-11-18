package com.jorgito.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.jorgito.demo.servicios.SistemaServices;
import org.springframework.ui.Model;
import com.jorgito.demo.servicios.JorgitoException;

@Controller
public class ComentarioPageController {

    @Autowired
    SistemaServices sistema;

    // GET para obtener una página
    @GetMapping("/app/publications")
    public String mostrarPagina(Model model) {
        return "publications.html";
}

  /*   @PostMapping("/app/publications")
    public String procesarFormulario (
    @ModelAttribute(name = "loginForm") CommentFormDTO commentForm,
    Model model) throws JorgitoException{

    // saca los datos del formulario
    System.out.println(commentForm.getComentario());

    // llama a la logica de negocio
    boolean resultado = false;
    String comentario = commentForm.getComentario();
    //sistema.crearComentario();

    model.addAttribute("loginForm", commentForm);

    if (resultado == true)
        return "home.html";
    else 
        return "login.html";
}   */

}
