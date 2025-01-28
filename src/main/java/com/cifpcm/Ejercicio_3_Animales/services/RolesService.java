package com.cifpcm.Ejercicio_3_Animales.services;

import com.cifpcm.Ejercicio_3_Animales.models.Role;
import com.cifpcm.Ejercicio_3_Animales.repositories.RolesAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;

@Primary
@Service
public class RolesService implements com.cifpcm.Ejercicio_3_Animales.interfaces.RolesService {

    @Autowired
    RolesAppRepository repository;

    @Override
    public List<Role> list() {
        return repository.findAll();
    }

    @Override
    public Role detail(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void create(Role role) {
        repository.save(role);
    }

    @Override
    public void edit(int id, Role role) {
        repository.save(role);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    public Role findByName(String name) {
        return repository.findByName(name);
    }
}
