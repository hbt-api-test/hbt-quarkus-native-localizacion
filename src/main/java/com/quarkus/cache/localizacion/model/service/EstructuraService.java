package com.quarkus.cache.localizacion.model.service;


import com.quarkus.cache.localizacion.model.entity.EstructuraDTO;
import com.quarkus.cache.localizacion.model.entity.EstructuraGeografica;
import com.quarkus.cache.localizacion.model.repository.IEstructuraRepository;
import com.quarkus.cache.localizacion.model.service.interfaces.IEstructuraService;
import io.quarkus.cache.CacheResult;
import lombok.extern.slf4j.Slf4j;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class EstructuraService implements IEstructuraService {

    @Inject
    IEstructuraRepository estructuraRepository;

    @Override
    public List<EstructuraGeografica> findAll() {
        return estructuraRepository.findAll();
    }

    @Override
    @CacheResult(cacheName = "localizacion-cache")
    public List<EstructuraDTO> findByIdNivel(Long id, String codigoIso) {

        List<EstructuraGeografica> estructuras = estructuraRepository.findByNivel_IdAndCodigoIsoStartingWith(id,codigoIso);


        List<EstructuraDTO> dtos =   estructuras.stream()
                .map(e -> {
                    EstructuraDTO estructuraDTO = new EstructuraDTO();
                    estructuraDTO.setId(e.getId());
                    estructuraDTO.setNombre(e.getNombreUbicacion());

                    estructuraDTO.setUbicacion(padres(e.getUbicacionPadre(),
                            e.getUbicacionPadre().getNombreUbicacion()));

                    return estructuraDTO;

                }).collect(Collectors.toList());



        return  dtos;
    }

    private String padres(EstructuraGeografica padre, String ubicacion){
        if(padre.getUbicacionPadre() != null){
            ubicacion = padres(padre.getUbicacionPadre(), ubicacion + " -> " + padre.getUbicacionPadre().getNombreUbicacion());
        }
        return ubicacion;
    }



}
