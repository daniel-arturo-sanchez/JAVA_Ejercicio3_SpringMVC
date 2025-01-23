package com.cifpcm.Ejercicio_3_Animales.controllers;

import com.cifpcm.Ejercicio_3_Animales.models.Animal;
import com.cifpcm.Ejercicio_3_Animales.services.AnimalsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnimalesController {
    @Autowired
    AnimalsService as;

    @GetMapping("/animales")
    public String listaAnimales(Model model){
        model.addAttribute("animals", as.list());
        return "animals/index";
    }

    @GetMapping("/animales/crear")
    public String crearAnimal(Model model){
        model.addAttribute("animal", new Animal());
        return "animals/create";
    }
    @PostMapping("/animales/crear")
    public String crearAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult){
        String result;
        if(bindingResult.hasErrors()){
            result = "/animals/create";
        } else {
            animal.setId(as.animalId());
            as.create(animal);
            result = "redirect:/animales";
        }
        return result;
    }

    @GetMapping("/animales/detalles/{id}")
    public String detallesAnimal(@PathVariable int id, Model model){
        model.addAttribute("animal", as.detail(id));
        return "animals/details";
    }

    @GetMapping("/animales/editar/{id}")
    public String editarAnimal(@PathVariable int id, Model model){
        String result = null;
        Animal editAnimal = as.detail(id);
        if(editAnimal != null){
            model.addAttribute("animal", editAnimal);
            result = "animals/edit";
        }
        return result;
    }

    @PostMapping("/animales/editar/{id}")
    public String editarAnimal(@PathVariable int id, @Valid @ModelAttribute Animal animal, BindingResult bindingResult){
        String result;
        if(bindingResult.hasErrors()){
            result = "animals/edit";
        } else {
            as.edit(id, animal);
            result = "redirect:/animales";
        }
        return result;
    }

    @GetMapping("/animales/borrar/{id}")
    public String eliminarAnimal(@PathVariable int id, Model model){
        String result;
        Animal deleteAnimal = as.detail(id);
        if(deleteAnimal != null){
            model.addAttribute("animal", deleteAnimal);
            result = "animals/delete";
        } else {
            result = "redirect:/animales";
        }
        return result;
    }

    @PostMapping("/animales/borrar/{id}")
    public String eliminarAnimal(@PathVariable int id){
        as.delete(id);
        return "redirect:/animales";
    }

}
