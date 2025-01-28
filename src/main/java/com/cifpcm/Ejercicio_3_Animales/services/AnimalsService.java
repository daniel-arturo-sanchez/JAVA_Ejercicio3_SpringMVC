package com.cifpcm.Ejercicio_3_Animales.services;

import com.cifpcm.Ejercicio_3_Animales.models.Animal;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalsService implements com.cifpcm.Ejercicio_3_Animales.interfaces.AnimalsService {
    private List<Animal> animals;
    private static int animalId = 1;

    AnimalsService() {
        animals = new ArrayList<Animal>();
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();

        animal1.setId(animalId++);
        animal1.setName("Perro");
        animal1.setAverageLife(12);
        animal1.setIsExtinct(false);

        animal2.setId(animalId++);
        animal2.setName("Gato");
        animal2.setAverageLife(15);
        animal2.setIsExtinct(false);

        animal3.setId(animalId++);
        animal3.setName("Dodo");
        animal3.setAverageLife(5);
        animal3.setIsExtinct(true);

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
    }

    public int animalId(){
        return animalId;
    }

    public List<Animal> list(){
        return animals.stream().toList();
    }

    public Animal detail(int id){
        Animal result = null;
        Animal animalResult = animals.stream()
                                    .filter(animal -> animal.getId() == id).findFirst().orElse(null);
        if(animalResult != null){
            result = animalResult;
        }
        return result;
    }

    public void create(Animal animal){
        animals.add(animal);
        animalId++;
    }

    public void edit(int id, Animal animal){
        Animal editAnimal = animals.stream().filter(animale -> animale.getId() == id).findFirst().get();;

        if(editAnimal != null){
            editAnimal.setName(animal.getName());
            editAnimal.setAverageLife(animal.getAverageLife());
            editAnimal.setIsExtinct(animal.getIsExtinct());
        };
    }

    public void delete(int id){
        Animal toBeDeleted = animals.get(id - 1);

        if(toBeDeleted != null){
            animals.remove(toBeDeleted);
        };
    }

}
