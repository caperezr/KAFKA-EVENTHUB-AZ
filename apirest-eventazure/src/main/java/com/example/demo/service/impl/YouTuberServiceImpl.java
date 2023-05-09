package com.example.demo.service.impl;

import com.example.demo.dto.YouTuberDTO;
import com.example.demo.exception.YouTuberNotFoundException;
import com.example.demo.model.YouTuber;
import com.example.demo.repository.YouTuberRepository;
import com.example.demo.service.YouTuberService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YouTuberServiceImpl implements YouTuberService {


    private final YouTuberRepository youtuberRepository;

    public YouTuberServiceImpl(YouTuberRepository youtuberRepository) {
        this.youtuberRepository = youtuberRepository;
    }

    @Override
    public YouTuber crearYouTuber(YouTuberDTO youTuberDTO) {
        YouTuber youTuber = new YouTuber(youTuberDTO);
        return youtuberRepository.save(youTuber);
    }

    @Override
    public List<YouTuber> obtenerTodosLosYouTubers() {
        return youtuberRepository.findAll();
    }

    @Override
    public YouTuber obtenerYouTuberPorId(String id) {
        Optional<YouTuber> youtuber = youtuberRepository.findById(id);
        if (youtuber.isPresent()) {
            return youtuber.get();
        } else {
            throw new YouTuberNotFoundException("No se encontró el YouTuber con el id: " + id);
        }
    }

    @Override
    public YouTuber actualizarYouTuber(String id, YouTuberDTO youTuberDTO) {
        Optional<YouTuber> youtuber = youtuberRepository.findById(id);
        if (youtuber.isPresent()) {
            YouTuber youtuberActualizado = youtuber.get();
            youtuberActualizado.setNombre(youTuberDTO.getNombre());
            youtuberActualizado.setCanal(youTuberDTO.getCanal());
            youtuberActualizado.setDescripcion(youTuberDTO.getDescripcion());
            // Actualiza otros atributos según criterio
            return youtuberRepository.save(youtuberActualizado);
        } else {
            throw new YouTuberNotFoundException("No se encontró el YouTuber con el id: " + id);
        }
    }

    @Override
    public void eliminarYouTuber(String id) {
        Optional<YouTuber> youtuber = youtuberRepository.findById(id);
        if (youtuber.isPresent()) {
            youtuberRepository.deleteById(id);
        } else {
            throw new YouTuberNotFoundException("No se encontró el YouTuber con el id: " + id);
        }
    }

    @Override
    public void subscribe(String id) {

    }

    @Override
    public void unsubscribe(String id) {

    }
}
