//package com.cifpcm.Ejercicio_3_Animales.services;
////
////import com.cifpcm.Ejercicio_3_Animales.interfaces.FamilyService;
////import com.cifpcm.Ejercicio_3_Animales.models.Family;
////import com.cifpcm.Ejercicio_3_Animales.repositories.FamiliesAppRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Primary
//@Service
//public class FamilyServiceSQL implements FamilyService {
//
//    @Autowired
//    FamiliesAppRepository repository;
//
//    @Override
//    public List<Family> list() {
//        return repository.findAll();
//    }
//
//    @Override
//    public Family detail(int id) {
//        return repository.findById(id).get();
//    }
//
//    @Override
//    public void create(Family family) {
//        repository.save(family);
//    }
//
//    @Override
//    public void edit(int id, Family family) {
//        repository.save(family);
//    }
//
//    @Override
//    public void delete(int id) {
//        repository.deleteById(id);
//    }
//
//    public Family findByName(String name) {
//        return repository.findByName(name);
//    }
//
//}
