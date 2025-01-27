package com.cifpcm.Ejercicio_3_Animales.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Se requiere de un nombre para crear un animal")
    @NotNull(message = "Se requiere de un nombre para crear un animal")
    @Size(min = 3, max = 15, message = "Este campo debe contener entre 3 y 15 caracteres")
    private String name;

    @NotNull(message = "Se requiere un valor para este campo")
    @Min(value = 0, message = "El valor mínimo permitido es 0")
    @Max(value = 600, message = "El valor máximo permitido es 600")
    private int averageLife;

    @NotNull(message = "No se aceptan valores nulos para este campo")
    private boolean isExtinct;

    @ManyToOne
    private Family family;

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

    public int getAverageLife() {
        return averageLife;
    }

    public void setAverageLife(int averageLife){
        this.averageLife = averageLife;
    }

    public boolean getIsExtinct(){
        return isExtinct;
    }

    public void setIsExtinct(boolean isExtinct){
        this.isExtinct = isExtinct;
    }

    public Family getFamily() {return family;}

    public void setFamily(Family family) { this.family = family; }

}
