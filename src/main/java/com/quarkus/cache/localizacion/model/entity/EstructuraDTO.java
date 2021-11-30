package com.quarkus.cache.localizacion.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstructuraDTO {

    private Long id;
    private String nombre;
    private String ubicacion;

}
