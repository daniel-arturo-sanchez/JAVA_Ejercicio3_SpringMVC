package com.cifpcm.Ejercicio_3_Animales.controllers;

import com.cifpcm.Ejercicio_3_Animales.repositories.UsersAppRepository;
import com.cifpcm.Ejercicio_3_Animales.services.RolesService;
import com.cifpcm.Ejercicio_3_Animales.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @Autowired
    UsersService usersService;

    @Autowired
    RolesService rolesService;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}
