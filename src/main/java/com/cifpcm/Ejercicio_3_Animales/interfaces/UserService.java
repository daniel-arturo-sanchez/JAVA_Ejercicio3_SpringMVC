package com.cifpcm.Ejercicio_3_Animales.interfaces;

import com.cifpcm.Ejercicio_3_Animales.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> list();

    public User detail(int id);

    public void create(User role) throws Exception;

    public void edit(int id, User role);

    public void delete(int id);
}
