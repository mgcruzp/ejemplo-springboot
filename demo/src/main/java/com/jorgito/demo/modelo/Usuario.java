package com.jorgito.demo.modelo;

import java.util.List;

import com.google.common.base.Optional;
import com.jorgito.demo.repositorio.UsuarioRepository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {
    UsuarioRepository usuarioRepository;

    @Id
    @GeneratedValue
    Long id; // se usa un id para la normalizacion ya que las tablas se basan segun las clases

    @Column(unique = true, nullable = false)
    String email;

    @Column(unique = false, nullable = false)
    String contra;
    
    String nombre;

    @Column(unique = false, nullable = true)
    String apellido;

    
    int edad;

    @Column(unique = true, nullable = false)
    int teléfono;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    List<Inscripciones> inscripciones;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.REMOVE)
    List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "dadorLike", cascade = CascadeType.REMOVE)
    List<LikePublicaciones> likesDados;
    
    @OneToMany(mappedBy = "autor", cascade = CascadeType.REMOVE)
    List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    List<LikeComentarios> likesComentarios;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(int teléfono) {
        this.teléfono = teléfono;
    }

    public List<Inscripciones> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripciones> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public List<LikePublicaciones> getLikesDados() {
        return likesDados;
    }

    public void setLikesDados(List<LikePublicaciones> likesDados) {
        this.likesDados = likesDados;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<LikeComentarios> getLikesComentarios() {
        return likesComentarios;
    }

    public void setLikesComentarios(List<LikeComentarios> likesComentarios) {
        this.likesComentarios = likesComentarios;
    }
    public void setFromUsuario(Usuario usuario) {
        if (usuario != null) {
            this.email = usuario.getEmail();
            this.contra = usuario.getContra();
            this.nombre = usuario.getNombre();
            this.apellido = usuario.getApellido();
            this.edad = usuario.getEdad();
            this.teléfono = usuario.getTeléfono();
            this.inscripciones = usuario.getInscripciones();
            this.publicaciones = usuario.getPublicaciones();
            this.likesDados = usuario.getLikesDados();
            this.comentarios = usuario.getComentarios();
            this.likesComentarios = usuario.getLikesComentarios();
        }
    }

    boolean iniciarSesion(String email, String contra){
        if(usuarioRepository.existsByEmail(email)){
            Usuario newUser = usuarioRepository.findByEmail(email);
            
            // Si el usuario está presente
            if (newUser != null) {
                
                // Verifica si la contraseña es correcta
                if (newUser.getContra().equals(contra)) {
                    setFromUsuario(newUser);

                    return true;
                } else {
                    return false;
                }
            }
        }
    

    }

}
