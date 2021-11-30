package com.quarkus.cache.localizacion.model.service;


import com.quarkus.cache.localizacion.model.entity.EstructuraDTO;
import com.quarkus.cache.localizacion.model.entity.EstructuraGeografica;
import com.quarkus.cache.localizacion.model.repository.IEstructuraRepository;
import com.quarkus.cache.localizacion.model.service.interfaces.IEstructuraService;
import io.quarkus.cache.CacheResult;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class EstructuraService implements IEstructuraService {

    @Inject
    IEstructuraRepository estructuraRepository;

    @Override
    public List<EstructuraGeografica> findAll() {
        return estructuraRepository.findAll();
    }

    @Override
    @CacheResult(cacheName = "localizacion-cache")
    public List<EstructuraDTO> findByIdNivel(Long id) {

        List<EstructuraGeografica> estructuras = estructuraRepository.findByNivel_Id(id);


        List<EstructuraDTO> dtos =   estructuras.stream()
                .map(e -> {
                    EstructuraDTO estructuraDTO = new EstructuraDTO();
                    estructuraDTO.setId(e.getId());
                    estructuraDTO.setNombre(e.getNombreUbicacion());

                    String prov = e.getUbicacionPadre().getNombreUbicacion();
                    String dpto = e.getUbicacionPadre().getUbicacionPadre().getNombreUbicacion();
                    String pais = e.getUbicacionPadre().getUbicacionPadre().getUbicacionPadre().getNombreUbicacion();

                    estructuraDTO.setUbicacion(pais + "->" + dpto + "->" + prov);
                    return estructuraDTO;

                }).collect(Collectors.toList());



        return  dtos;
    }
}
