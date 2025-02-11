package com.cifpcm.Ejercicio_3_Animales.services;
//
//import com.cifpcm.Ejercicio_3_Animales.models.Role;
//import com.cifpcm.Ejercicio_3_Animales.models.User;
//import com.cifpcm.Ejercicio_3_Animales.repositories.RolesAppRepository;
//import com.cifpcm.Ejercicio_3_Animales.repositories.UsersAppRepository;
//import com.cifpcm.Ejercicio_3_Animales.security.SecurityConfig;
////import com.cifpcm.Ejercicio_3_Animales.security.SecurityConfig;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
////import org.springframework.security.core.GrantedAuthority;
////import org.springframework.security.core.authority.SimpleGrantedAuthority;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UsernameNotFoundException;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
////import com.cifpcm.Ejercicio_3_Animales.security.SecurityConfig;
//
//@Primary
//@Service
//public class UserService implements com.cifpcm.Ejercicio_3_Animales.interfaces.UserService {
//
//    @Autowired
//    UsersAppRepository repository;
//
//    @Autowired
//    RolesAppRepository rolesAppRepository;
//
//    @Override
//    public List<User> list() {
//        return repository.findAll();
//    }
//
//    @Override
//    public User detail(int id) {
//        return repository.findById(id).get();
//    }
//
//    @Override
//    public void create(User user) throws Exception {
//        user.setRoles(new ArrayList<Role>());
//        user.getRoles().add(rolesAppRepository.findByName("ROLE_USER"));
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        user.setPassword(encoder.encode(user.getPassword()));
//        repository.save(user);
//    }
//
//    @Override
//    public void edit(int id, User user) {
//        repository.save(user);
//    }
//
//    @Override
//    public void delete(int id) {
//        repository.deleteById(id);
//    }
//
//    public User findByUsername(String name) {
//        return repository.findByUsername(name);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = repository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        UserDetails userDetails = new UserDetails() {
//            @Override
//            public Collection<? extends GrantedAuthority> getAuthorities() {
//                return List.of();
//            }
//
//            @Override
//            public String getPassword() {
//                return user.getPassword();
//            }
//
//            @Override
//            public String getUsername() {
//                return user.getUsername();
//            }
//        };
//        return userDetails;
//    }
//}
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//            User user = repository.findByUsername(username);
//            if (user == null) {
//                throw new UsernameNotFoundException(username);
//            }
//            return new UserDetails() {
//                @Override
//                public Collection<? extends GrantedAuthority> getAuthorities() {
//                    return user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//                }
//
//                @Override
//                public String getPassword() {
//                    return user.getPassword();
//                }
//
//                @Override
//                public String getUsername() {
//                    return user.getUsername();
//                }
//            };
//    }