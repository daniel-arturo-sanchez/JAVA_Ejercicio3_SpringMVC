package com.cifpcm.Ejercicio_3_Animales.services;

import com.cifpcm.Ejercicio_3_Animales.models.Role;
import com.cifpcm.Ejercicio_3_Animales.models.User;
import com.cifpcm.Ejercicio_3_Animales.repositories.RolesAppRepository;
import com.cifpcm.Ejercicio_3_Animales.repositories.UsersAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
public class UsersService implements com.cifpcm.Ejercicio_3_Animales.interfaces.UsersService {

    @Autowired
    UsersAppRepository repository;

    @Autowired
    RolesAppRepository rolesAppRepository;

    @Override
    public List<User> list() {
        return repository.findAll();
    }

    @Override
    public User detail(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void create(User user) {
        List<Role> roles = user.getRoles();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        repository.save(user);
    }

    @Override
    public void edit(int id, User user) {
        repository.save(user);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    public User findByUsername(String name) {
        return repository.findByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return repository.findByUsername(username).getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
            }

            @Override
            public String getPassword() {
                return repository.findByUsername(username).getPassword();
            }

            @Override
            public String getUsername() {
                return repository.findByUsername(username).getUsername();
            }
        };
    }
}
