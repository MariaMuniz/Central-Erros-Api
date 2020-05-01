package com.cental.apirest.service;

import com.cental.apirest.model.Log;
import com.cental.apirest.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class LogServiceImpl implements LogServiceInterface {

    @Autowired
    LogRepository logRepository;

    @Override
    public List<Log> listar(String level, String description, String origin, String title, String details, Long user_id, Pageable pageable) {
        if (level != null) {
            return logRepository.findByLevel(level, pageable).getContent();
        }

        if (description != null) {
            return logRepository.findByDescription(description, pageable).getContent();
        }
        if (origin != null) {
            return logRepository.findByOrigin(origin, pageable).getContent();
        }

        if (title != null) {
            return logRepository.findByTitle(title, pageable).getContent();
        }
        if (details != null) {
            return logRepository.findByDetails(details, pageable).getContent();
        }
        if (user_id != null) {
            return logRepository.findByUserId(user_id, pageable).getContent();
        }
        return logRepository.findAll(pageable).getContent();

    }


    @Override
    public Optional<Log> findById(Long id) {

        return this.logRepository.findById(id);

    }


    public Log save(Log log) {
        log.setCreatedAt(LocalDateTime.now());
        return this.logRepository.save(log);
    }

}



