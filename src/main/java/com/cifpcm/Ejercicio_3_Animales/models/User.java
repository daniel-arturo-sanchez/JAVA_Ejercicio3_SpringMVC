package com.cifpcm.Ejercicio_3_Animales.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {
    private @Id @Setter(AccessLevel.PROTECTED)
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            int id;
    @Email
    @UniqueElements
    private String username;

    private String password;

    @ManyToMany
    private List<Role> roles;
}
