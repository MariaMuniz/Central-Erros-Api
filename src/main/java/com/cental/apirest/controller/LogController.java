package com.cental.apirest.controller;


import com.cental.apirest.model.Log;
import com.cental.apirest.service.LogServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/logs")
@Api(value = "Api Rest Logs")

@CrossOrigin(origins = "*")

public class LogController {


    @Autowired
    LogServiceImpl logService;

    @GetMapping
    public List<Log> listar(@PathParam("level") String level,
                            @PathParam("description") String description,
                            @PathParam("origin") String origin,
                            @PathParam("title") String title,
                            @PathParam("details") String details,
                            @PathParam("user_id") Long user_id, Pageable pageable) {
        return this.logService.listar(level, description, origin, title, details, user_id, pageable);

    }

    @ApiOperation(value = "Retorna a um log correspondente ao id")
    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")

    public ResponseEntity<Log> buscar(@PathVariable Long id) {
        Optional<Log> log = logService.findById(id);
        if (log.isPresent()) {
            return ResponseEntity.ok(log.get());
        }

        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @ApiOperation(value = "Insere um log")

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Log save(@RequestBody Log log) {
        return this.logService.save(log);
    }


}