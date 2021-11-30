package com.quarkus.cache.localizacion.model.service.interfaces;



import com.quarkus.cache.localizacion.model.entity.EstructuraDTO;
import com.quarkus.cache.localizacion.model.entity.EstructuraGeografica;

import java.util.List;

public interface IEstructuraService {

    List<EstructuraGeografica> findAll();
    List<EstructuraDTO> findByIdNivel(Long id);

}
