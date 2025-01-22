package com.cifpcm.Ejercicio_3_Animales.interfaces;

import com.cifpcm.Ejercicio_3_Animales.models.Animal;

import java.util.List;

public interface IAnimalsService {

    public List<Animal> list();

    public Animal detail(int id);

    public void create(Animal animal);

    public void edit(int id, Animal animal);

    public void delete(int id);
}
