package com.cental.apirest.repository;

import com.cental.apirest.model.Log;
import com.cental.apirest.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    Log findOneById(Long id);

    Optional<Log>findById(Long id);
    Page<Log> findByLevel(String level, Pageable pageable);
    Page<Log> findByDescription (String description, Pageable pageable);
    Page<Log> findByOrigin(String origin, Pageable pageable);
    Page<Log>findAll (Pageable pageable);



}