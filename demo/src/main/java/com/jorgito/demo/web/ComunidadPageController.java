package com.jorgito.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jorgito.demo.modelo.Comunidad;
import com.jorgito.demo.modelo.Usuario;
import com.jorgito.demo.repositorio.ComunidadRepository;
import com.jorgito.demo.servicios.JorgitoException;
import com.jorgito.demo.servicios.SistemaServices;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class ComunidadPageController {
   
    @Autowired
    SistemaServices sistema;

    @Autowired
    ComunidadRepository comunidadRepository;

    // GET para obtener una página
    @GetMapping("/app/communities")
    public String mostrarPagina(
        Model model,
        @SessionAttribute(name = "usuario", required = true) Usuario usuarioActual // usuario actual en la sesión
    ) {

        Iterable<Comunidad> comunidades = comunidadRepository.findAll(); 

        model.addAttribute("usuarioActual", usuarioActual);
        model.addAttribute("comunidades", comunidades);

        return "communities.html";
    }


    @PostMapping("(/app/communities")
    public String unirmeAGrupo(RedirectAttributes redirectAttributes) throws JorgitoException{
        
        boolean resultado = false;
        // Lógica para añadir al usuario al grupo
        resultado = sistema.entrarAComunidad(null);
        if (resultado == true){ 
        // Agregar un mensaje de éxito para mostrarlo en la interfaz (opcional)
        redirectAttributes.addFlashAttribute("mensaje", "¡Te has unido exitosamente al grupo!");

        // Redirigir al usuario a la página actual u otra
        return "communities.html";
        }
        else {
            redirectAttributes.addFlashAttribute("mensaje", "¡No se ha podido unir al grupo!");
            return "communities.html";
        }
        
    }
}

