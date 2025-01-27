package com.cifpcm.Ejercicio_3_Animales.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {
    private @Id @Setter(AccessLevel.PROTECTED)
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            int id;
}
