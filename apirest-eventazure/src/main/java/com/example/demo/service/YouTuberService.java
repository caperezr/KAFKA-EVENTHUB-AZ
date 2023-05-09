package com.example.demo.service;

import com.example.demo.dto.YouTuberDTO;
import com.example.demo.model.YouTuber;

import java.util.List;

public interface YouTuberService {
    YouTuber crearYouTuber(YouTuberDTO youTuberDTO);
    List<YouTuber> obtenerTodosLosYouTubers();
    YouTuber obtenerYouTuberPorId(String id);
    YouTuber actualizarYouTuber(String id, YouTuberDTO youTuberDTO);
    void eliminarYouTuber(String id);
    void subscribe(String id);
    void unsubscribe(String id);

}
