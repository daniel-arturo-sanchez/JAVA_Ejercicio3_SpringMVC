package com.cifpcm.Ejercicio_3_Animales.services;

import com.cifpcm.Ejercicio_3_Animales.models.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalsService {
    private List<Animal> animals;

    public List<Animal> list(){
        return animals;
    }

    public Animal detail(int id){
        return animals.get(id);
    }

    public void create(Animal animal){
        animals.add(animal);
    }

    public void edit(int id, Animal animal){
        Animal editAnimal = animals.get(id);

        if(editAnimal != null){
            editAnimal.setName(animal.getName());
            editAnimal.setAverageLife(animal.getAverageLife());
            editAnimal.setIsExtinct(animal.getIsExtinct());
        };
    }

    public void delete(int id){
        Animal toBeDeleted = animals.get(id);

        if(toBeDeleted != null){
            animals.remove(toBeDeleted);
        };
    }
}
