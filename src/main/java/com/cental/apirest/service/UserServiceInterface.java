package com.cental.apirest.service;

import com.cental.apirest.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    Optional<User> findById(Long userId);


    Iterable<User> findAll();

    Optional<User> findByEmail(String email);



}