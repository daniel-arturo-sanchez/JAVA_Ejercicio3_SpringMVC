package com.cifpcm.Ejercicio_3_Animales.services;

import com.cifpcm.Ejercicio_3_Animales.interfaces.IAnimalsService;
import com.cifpcm.Ejercicio_3_Animales.models.Animal;
import com.cifpcm.Ejercicio_3_Animales.repositories.AnimalesAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Primary
@Service
public class AnimalsServiceSQL implements IAnimalsService {

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
}
