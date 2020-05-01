package com.cental.apirest.controller;

import com.cental.apirest.model.User;
import com.cental.apirest.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;


@RestController
@RequestMapping(value = "/users")
@Api(value = "Api Rest User")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @PostMapping
    @ApiOperation(value = "Adiciona um usuario")
    public ResponseEntity<User> adicionar(@RequestBody User user) {
        LocalDateTime date = LocalDateTime.now();
        user.setCreatedAt(date);
        User userRet = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userRet);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    @ApiOperation(value = "Retorna a todos os usuarios cadastrados")
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }


    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Retorna a um usuario correspondente ao id")
    @GetMapping("/{id}")
    public Optional<User> unico(@PathVariable Long id) {

        return this.userRepository.findById(id);
    }


}



