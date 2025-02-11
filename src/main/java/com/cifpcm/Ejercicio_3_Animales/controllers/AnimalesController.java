package com.cifpcm.Ejercicio_3_Animales.controllers;

import com.cifpcm.Ejercicio_3_Animales.models.Animal;
import com.cifpcm.Ejercicio_3_Animales.services.AnimalsService;
import com.cifpcm.Ejercicio_3_Animales.services.AnimalsServiceSQL;
import com.cifpcm.Ejercicio_3_Animales.services.FamilyServiceSQL;
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

    @Autowired
    AnimalsServiceSQL asSQL;

    @Autowired
    FamilyServiceSQL fs;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/animales")
    public String listaAnimales(Model model){
        model.addAttribute("animals", asSQL.list());
        model.addAttribute("families", fs.list());
        return "animals/index";
    }

    @GetMapping("/animales/crear")
    public String crearAnimal(Model model){
        model.addAttribute("animal", new Animal());
        model.addAttribute("families", fs.list());
        return "animals/create";
    }
    @PostMapping("/animales/crear")
    public String crearAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult){
        String result;
        if(bindingResult.hasErrors()){
            result = "/animals/create";
        } else {
            //animal.setId(as.animalId());
            asSQL.create(animal);
            result = "redirect:/animales";
        }
        return result;
    }

    @GetMapping("/animales/detalles/{id}")
    public String detallesAnimal(@PathVariable int id, Model model){
        model.addAttribute("animal", asSQL.detail(id));
        model.addAttribute("family", fs.list());
        return "animals/details";
    }

    @GetMapping("/animales/editar/{id}")
    public String editarAnimal(@PathVariable int id, Model model){
        String result = null;
        Animal editAnimal = asSQL.detail(id);
        if(editAnimal != null){
            model.addAttribute("animal", editAnimal);
            model.addAttribute("families", fs.list());
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
            asSQL.edit(id, animal);
            result = "redirect:/animales";
        }
        return result;
    }

    @GetMapping("/animales/borrar/{id}")
    public String eliminarAnimal(@PathVariable int id, Model model){
        String result;
        Animal deleteAnimal = asSQL.detail(id);
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
        asSQL.delete(id);
        return "redirect:/animales";
    }
}
