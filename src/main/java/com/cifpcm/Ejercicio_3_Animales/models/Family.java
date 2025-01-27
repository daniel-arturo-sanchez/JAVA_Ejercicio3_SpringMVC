package com.cifpcm.Ejercicio_3_Animales.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Se requiere de un nombre para crear un animal")
    @NotNull(message = "Se requiere de un nombre para crear un animal")
    @Size(min = 3, max = 15, message = "Este campo debe contener entre 3 y 15 caracteres")
    private String name;

    @OneToMany(mappedBy = "family",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Animal> animals;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public  List<Animal> getAnimals() { return animals; }
}
