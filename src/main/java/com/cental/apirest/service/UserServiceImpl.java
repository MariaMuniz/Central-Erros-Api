package com.cental.apirest.service;

import com.cental.apirest.model.Log;
import com.cental.apirest.model.User;
import com.cental.apirest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInterface, UserDetailsService {

    @Autowired
    UserRepository userRepository;



    public User save(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return this.userRepository.findById(userId);
    }


    @Override
    public Iterable<User> findAll() {

        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return this.userRepository.findByEmail(email);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s).get();
    }
}
