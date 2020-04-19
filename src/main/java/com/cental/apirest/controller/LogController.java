package com.cental.apirest.controller;

import com.cental.apirest.ResourceNotFoundExcception;
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
@RestController
@RequestMapping(value = "/logs")
@Api(value = "Api Rest Logs")

@CrossOrigin(origins = "*")

public class LogController {

    @Autowired
    LogServiceImpl logService;
    @ApiOperation(value="/logs?sort=description, retorna aos logs com description ordenada, /logs?page=0&size=2, retorna a primeira pagina com 2 elememtos, /logs?level=ERROR, retorna aos logs que contenha a palavara ERROR ")
    @GetMapping
    public List<Log>listar(@PathParam("level")String level,
                           @PathParam("description")String description,
                           @PathParam("origin")String origin, Pageable pageable) {
        return this.logService.listar(level, description, origin, pageable);

    }
  @ApiOperation(value="Retorna a um log correspondente ao id")
      @GetMapping("/{id}")
      @CrossOrigin(origins = "*")
  public ResponseEntity<Log>show(@PathVariable("id") Long id) throws Throwable {
         return new ResponseEntity<Log>((Log) this.logService.show(id).orElseThrow(()-> new ResourceNotFoundExcception("Log")),HttpStatus.OK);
    }





    @CrossOrigin(origins = "*")
    @ApiOperation(value="Insere um log")
    @PostMapping
    public Log save(@RequestBody Log log){
            return this.logService.save(log);
    }



}

