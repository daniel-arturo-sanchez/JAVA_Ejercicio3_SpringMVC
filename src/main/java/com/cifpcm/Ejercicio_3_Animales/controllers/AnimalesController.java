package com.cifpcm.Ejercicio_3_Animales.controllers;

import com.cifpcm.Ejercicio_3_Animales.models.Animal;
import com.cifpcm.Ejercicio_3_Animales.services.AnimalsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnimalesController {
    @Autowired
    AnimalsService as;

    @GetMapping("/animales")
    public String listaAnimales(Model model){
        return "animals/index";
    }

    @GetMapping("/animales/crear")
    public String crearAnimal(Model model){
        model.addAttribute("animal", new Animal());
        return "animals/create";
    }
    @PostMapping("/animales/create")
    public String crearAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult){
        String result;
        if(bindingResult.hasErrors()){
            result = "/animals/create";
        } else {
            result = "redirect:/animales";
        }
        return result;
    }

    @GetMapping("/animales/detalles/{id}")
    public String detallesAnimal(@PathVariable int id, Model model){
        return "animals/details";
    }

    @GetMapping("/animales/editar")
    public String editarAnimal(Model model){
        return "animals/edit";
    }

    @GetMapping("/animales/borrar")
    public String eliminarAnimal(Model model){
        return "animals/delete";
    }
}
