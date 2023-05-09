package com.example.demo.service;

import com.example.demo.dto.SuscriptorDTO;
import com.example.demo.model.Suscriptor;
import org.springframework.stereotype.Service;

@Service
public interface SuscriptorService {
    Suscriptor crearSuscriptor(SuscriptorDTO suscriptorDTO);
    void eliminarSuscriptor(String id);
}
