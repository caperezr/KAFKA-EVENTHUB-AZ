package com.example.demo.model;

import com.example.demo.dto.YouTuberDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "youtubers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YouTuber {
    @Id
    private String id;
    private String nombre;
    private String canal;
    private String descripcion;
    private double suscriptores;

    public YouTuber(YouTuberDTO youTuberDTO){
        this.nombre = youTuberDTO.getNombre();
        this.canal = youTuberDTO.getCanal();
        this.descripcion = youTuberDTO.getDescripcion();
    }
}
