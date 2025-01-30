package com.cifpcm.Ejercicio_3_Animales.repositories;

import com.cifpcm.Ejercicio_3_Animales.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesAppRepository extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
