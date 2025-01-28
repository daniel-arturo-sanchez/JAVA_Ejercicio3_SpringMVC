package com.cifpcm.Ejercicio_3_Animales.controllers;


import com.cifpcm.Ejercicio_3_Animales.models.Role;
import com.cifpcm.Ejercicio_3_Animales.models.User;
import com.cifpcm.Ejercicio_3_Animales.repositories.UsersAppRepository;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.cifpcm.Ejercicio_3_Animales.services.RolesService;
import com.cifpcm.Ejercicio_3_Animales.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    UsersService usersService;

    @Autowired
    RolesService rolesService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user",new User());

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
                usersService.create(user);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            result = "redirect:/animales";
        }
        return result;
    }

}
