package com.cifpcm.Ejercicio_3_Animales.repositories;

import com.cifpcm.Ejercicio_3_Animales.models.User;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersAppRepository extends JpaRepository<User, Integer> {
    public User findByUsername(@Email @UniqueElements String username);
}
