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
public class LogServiceImpl implements LogServiceInterface{

    @Autowired
    LogRepository logRepository;


        @Override
        public List <Log>listar(String level, String description, String origin, Pageable pageable){
            if (level!=null){
                return logRepository.findByLevel( level, pageable).getContent();
            }

            if (description!=null){
                return logRepository.findByDescription(description, pageable).getContent();
            }
            if (origin!=null){
                return logRepository.findByOrigin(origin, pageable).getContent();
            }
            return logRepository.findAll(pageable).getContent();
        }

    @Override
    public Object store(Object o) {
        return null;
    }

    @Override
    public Optional<Log> show(Long id) {

            return this.logRepository.findById(id);
    }



//        @Override
//        public Log store(Log log){
//            log.setDate(LocalDateTime.now());
//            return this.logRepository.save(log);
//        }

        public Log save(Log log) {
       log.setCreatedAt(LocalDateTime.now());
       return this.logRepository.save(log);
   }

}



