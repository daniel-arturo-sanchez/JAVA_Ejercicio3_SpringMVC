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
@Table( name = "Role" )
@Getter
@Setter @NoArgsConstructor
public class Role {

    @Column(name = "role_id")
    private @Id
    @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @UniqueElements
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
