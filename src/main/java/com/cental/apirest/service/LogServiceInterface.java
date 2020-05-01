package com.cental.apirest.service;


import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LogServiceInterface <Log> {

    List<Log> listar(String level, String description, String origin, String title, String details, Long user_id, Pageable pageable);

    Optional<Log> findById(Long id);

}