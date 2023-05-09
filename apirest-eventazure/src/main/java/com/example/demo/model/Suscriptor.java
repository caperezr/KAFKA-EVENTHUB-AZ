package com.example.demo.model;

import com.example.demo.dto.SuscriptorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "suscriptores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suscriptor {
    @Id
    private String id;
    private String nombre;
    private String correoElectronico;
    public Suscriptor(SuscriptorDTO suscriptorDTO){
        this.nombre = suscriptorDTO.getNombre();
        this.correoElectronico = suscriptorDTO.getCorreoElectronico();
    }
}
