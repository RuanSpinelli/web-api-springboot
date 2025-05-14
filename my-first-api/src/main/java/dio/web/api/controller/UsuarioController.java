package dio.web.api.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dio.web.api.model.Usuario;
import dio.web.api.repository.UserRepository;



@RestController
public class UsuarioController {
    
    @Autowired
    public UserRepository repository;


    @GetMapping("/users")
    public List<Usuario> getUser() {
        return repository.findAll();
    }

    @GetMapping("/users/{username}")
    public Usuario findOne(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

}
