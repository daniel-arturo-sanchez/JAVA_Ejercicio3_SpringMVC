package com.cifpcm.Ejercicio_3_Animales.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Entity
@Getter
@Setter @NoArgsConstructor
public class Role {
    private @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @UniqueElements
    private String name;

    @ManyToMany
    private List<User> users;
}
