package com.cifpcm.Ejercicio_3_Animales.models;

import jakarta.validation.constraints.*;

public class Animal {

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
