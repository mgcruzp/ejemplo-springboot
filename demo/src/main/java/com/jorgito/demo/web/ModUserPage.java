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
public class ModUserPage {

    @Autowired
    SistemaServices sistema;

    // GET para obtener una página
    @GetMapping("/app/settings")
    public String mostrarPagina(Model model) {
        return "settings.html";
}

@PostMapping("/app/settings")
public String procesarFormulario (
    @ModelAttribute(name = "settingsForm") ModUserFormDTO ModUserForm,
    Model model) throws JorgitoException{

    // saca los datos del formulario
    System.out.println(ModUserForm.getNombre());
    System.out.println(ModUserForm.getApellido());
    System.out.println(ModUserForm.getEmail());
    System.out.println(ModUserForm.getPassword());

    // llama a la logica de negocio
    boolean resultado = false;
    String nombre = ModUserForm.getNombre();
    String apellido = ModUserForm.getApellido();
    String telefono = ModUserForm.getTelefono();
    int edad = ModUserForm.getEdad();
    String email = ModUserForm.getEmail();
    String passwd = ModUserForm.getPassword();
   
    
    if(nombre!=""){
        resultado=sistema.editarNombre(nombre);
    }
    if(apellido!=""){
        resultado=sistema.editarApellido(apellido);
    }
    if(telefono!=""){
        resultado=sistema.editarTelefono(telefono);
    }
    if(edad!=0){
       resultado=sistema.editarEdad(edad);
    }
    if(email!=""){
        resultado=sistema.editarEmail(email);
    }
    if(passwd!=""){
        resultado=sistema.editarContra(email, passwd);
    }


    model.addAttribute("registerForm", ModUserForm);

    if (resultado == true)
        return "home.html";
    else 
        return "settings.html";
}


}
