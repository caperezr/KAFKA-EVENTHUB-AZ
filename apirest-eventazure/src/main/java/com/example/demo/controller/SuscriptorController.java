package com.example.demo.controller;

import com.example.demo.dto.SuscriptorDTO;
import com.example.demo.model.Suscriptor;
import com.example.demo.service.SuscriptorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suscriptores")
@Slf4j
public class SuscriptorController {

    @Autowired
    private SuscriptorService suscriptorService;

    @PostMapping("")
    @Transactional
    public ResponseEntity<Suscriptor> crearSuscriptor(@RequestBody SuscriptorDTO suscriptorDTO) {
        try{
            Suscriptor nuevoSuscriptor = suscriptorService.crearSuscriptor(suscriptorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoSuscriptor);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSuscriptor(@PathVariable("id") String id) {
        try {
            suscriptorService.eliminarSuscriptor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}