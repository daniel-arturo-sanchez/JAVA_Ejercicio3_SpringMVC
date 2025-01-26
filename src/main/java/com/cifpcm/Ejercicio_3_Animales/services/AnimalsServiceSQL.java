package com.cifpcm.Ejercicio_3_Animales.services;

import com.cifpcm.Ejercicio_3_Animales.interfaces.AnimalsService;
import com.cifpcm.Ejercicio_3_Animales.models.Animal;
import com.cifpcm.Ejercicio_3_Animales.repositories.AnimalesAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class AnimalsServiceSQL implements AnimalsService {


    @Autowired
    AnimalesAppRepository repository;
    @Override
    public List<Animal> list() {
        return repository.findAll();
    }

    @Override
    public Animal detail(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void create(Animal animal) {
        repository.save(animal);
    }

    @Override
    public void edit(int id, Animal animal) {
        repository.save(animal);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    public Animal findByName(String name) {
        return repository.findByName(name);
    }
}
