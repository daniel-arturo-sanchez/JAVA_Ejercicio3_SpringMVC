package com.cifpcm.Ejercicio_3_Animales.repositories;

import com.cifpcm.Ejercicio_3_Animales.models.Animal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalesAppRepository extends JpaRepository<Animal, Integer> {
    Animal findByName(String name);
}
