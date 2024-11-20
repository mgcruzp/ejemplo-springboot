package com.jorgito.demo.web;

import lombok.Data;

@Data
public class RegisterFormDTO {

    String nombre = "";

    int edad = 0;

    String email = "";
    
    String password = "";


}
