package com.cifpcm.Ejercicio_3_Animales.controllers;


import com.cifpcm.Ejercicio_3_Animales.models.Role;
import com.cifpcm.Ejercicio_3_Animales.models.User;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.cifpcm.Ejercicio_3_Animales.services.RoleService;
import com.cifpcm.Ejercicio_3_Animales.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    @Autowired
    UserService usersService;

    @Autowired
    RoleService rolesService;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user",new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        String result;
        if(bindingResult.hasErrors()){
            return "auth/register";
        } else {
            try{
                Role role = rolesService.findByName("USER");
                List<Role> roles = user.getRoles();
                roles.add(role);
                usersService.create(user);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            result = "redirect:/animales";
        }
        return result;
    }

}
