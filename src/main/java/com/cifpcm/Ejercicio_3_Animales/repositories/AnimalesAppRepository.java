package com.cifpcm.Ejercicio_3_Animales.repositories;

import com.cifpcm.Ejercicio_3_Animales.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalesAppRepository extends JpaRepository<Animal, Integer> {
}
