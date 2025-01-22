package com.cifpcm.Ejercicio_3_Animales.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @NotBlank
    @NotNull
    @Min(0)
    @Max(600)
    private int averageLife;

    @NotNull
    @NotBlank
    private boolean isExtinct;

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
}
