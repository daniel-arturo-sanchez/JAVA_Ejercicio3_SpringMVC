package com.cifpcm.Ejercicio_3_Animales.controllers;

import com.cifpcm.Ejercicio_3_Animales.models.Animal;
import com.cifpcm.Ejercicio_3_Animales.models.Family;
import com.cifpcm.Ejercicio_3_Animales.services.FamilyServiceSQL;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FamiliasController {

    @Autowired
    FamilyServiceSQL fs;

    @GetMapping("/familias")
    public String listaFamilias(Model model){
        model.addAttribute("families", fs.list());
        return "familias/index";
    }

    @GetMapping("/familias/crear")
    public String crearAnimal(Model model){
        model.addAttribute("family", new Family());
        return "familias/create";
    }
    @PostMapping("/familias/crear")
    public String crearFamilia(@Valid @ModelAttribute("family") Family family, BindingResult bindingResult){
        String result;
        if(bindingResult.hasErrors()){
            result = "/familias/create";
        } else {
            //animal.setId(as.animalId());
            fs.create(family);
            result = "redirect:/familias";
        }
        return result;
    }

    @GetMapping("/familias/detalles/{id}")
    public String detallesFamilia(@PathVariable int id, Model model){
        model.addAttribute("family", fs.detail(id));
        return "familias/details";
    }

    @GetMapping("/familias/editar/{id}")
    public String editarFamilia(@PathVariable int id, Model model){
        String result = null;
        Family editFamily = fs.detail(id);
        if(editFamily != null){
            model.addAttribute("family", editFamily);
            result = "familias/edit";
        }
        return result;
    }

    @PostMapping("/familias/editar/{id}")
    public String editarFamilia(@PathVariable int id, @Valid @ModelAttribute Family family, BindingResult bindingResult){
        String result;
        if(bindingResult.hasErrors()){
            result = "familias/edit";
        } else {
            fs.edit(id, family);
            result = "redirect:/familias";
        }
        return result;
    }

    @GetMapping("/familias/borrar/{id}")
    public String eliminarFamilia(@PathVariable int id, Model model){
        String result;
        Family deleteFamily = fs.detail(id);
        if(deleteFamily != null){
            model.addAttribute("family", deleteFamily);
            result = "familias/delete";
        } else {
            result = "redirect:/familias";
        }
        return result;
    }

    @PostMapping("/familias/borrar/{id}")
    public String eliminarFamilia(@PathVariable int id){
        fs.delete(id);
        return "redirect:/familias";
    }
}
