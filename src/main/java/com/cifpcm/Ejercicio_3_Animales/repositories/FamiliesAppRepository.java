package com.cifpcm.Ejercicio_3_Animales.repositories;

import com.cifpcm.Ejercicio_3_Animales.models.Animal;
import com.cifpcm.Ejercicio_3_Animales.models.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliesAppRepository extends JpaRepository<Family, Integer> {
    public Family findByName(String name);
}
