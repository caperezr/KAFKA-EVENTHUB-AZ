package com.example.demo.controller;
import com.example.demo.dto.YouTuberDTO;
import com.example.demo.model.YouTuber;
import com.example.demo.service.YouTuberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
@RequestMapping("/youtubers")
public class YouTuberController {

    @Autowired
    private YouTuberService youTuberService;

    @PostMapping("")
    @Transactional
    public ResponseEntity<YouTuber> crearYouTuber(@RequestBody YouTuberDTO youTuberDTO) {
        try{
            YouTuber youtuberCreado = youTuberService.crearYouTuber(youTuberDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(youtuberCreado);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<YouTuber>> obtenerTodosLosYouTubers() {
        try {
            List<YouTuber> youtubers = youTuberService.obtenerTodosLosYouTubers();
            return ResponseEntity.status(HttpStatus.OK).body(youtubers);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<YouTuber> obtenerYouTuberPorId(@PathVariable("id") String id) {
        try{
            YouTuber youtuber = youTuberService.obtenerYouTuberPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(youtuber);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<YouTuber> actualizarYouTuber(@PathVariable("id") String id, @RequestBody YouTuberDTO youTuberDTO) {
        try{
            YouTuber youtuberActualizado = youTuberService.actualizarYouTuber(id, youTuberDTO);
            return ResponseEntity.status(HttpStatus.OK).body(youtuberActualizado);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarYouTuber(@PathVariable("id") String id) {
        try{
            youTuberService.eliminarYouTuber(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    /*
    // Endpoint para suscribirse a actualizaciones
    @PostMapping("/{id}/subscribe")
    public void subscribe(@PathVariable String id) {
        youtuberService.subscribe(id);
    }

    // Endpoint para cancelar la suscripción a actualizaciones
    @PostMapping("/{id}/unsubscribe")
    public void unsubscribe(@PathVariable String id) {
        youtuberService.unsubscribe(id);
    }*/
}
