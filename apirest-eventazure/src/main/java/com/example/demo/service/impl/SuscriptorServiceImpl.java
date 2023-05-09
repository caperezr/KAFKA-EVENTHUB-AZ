package com.example.demo.service.impl;

import com.example.demo.dto.SuscriptorDTO;
import com.example.demo.exception.SuscriptorNotFoundException;
import com.example.demo.model.Suscriptor;
import com.example.demo.repository.SuscriptorRepository;
import com.example.demo.service.SuscriptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SuscriptorServiceImpl implements SuscriptorService {
    @Autowired
    private SuscriptorRepository suscriptorRepository;
    @Override
    public Suscriptor crearSuscriptor(SuscriptorDTO suscriptorDTO) {
        Suscriptor suscriptor = new Suscriptor(suscriptorDTO);
        return suscriptorRepository.save(suscriptor);
    }

    @Override
    public void eliminarSuscriptor(String id) {
        Optional<Suscriptor> suscriptor = suscriptorRepository.findById(id);
        if(suscriptor.isPresent()){
            suscriptorRepository.deleteById(id);
        }else {
            throw new SuscriptorNotFoundException("No se encontró el Suscriptor con el id: " + id);
        }
    }
}
