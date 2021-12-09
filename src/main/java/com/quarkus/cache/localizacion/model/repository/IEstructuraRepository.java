package com.quarkus.cache.localizacion.model.repository;


import com.quarkus.cache.localizacion.model.entity.EstructuraGeografica;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.inject.Singleton;
import java.util.List;

@Singleton
public interface IEstructuraRepository extends JpaRepository<EstructuraGeografica, Long> {

    List<EstructuraGeografica> findByNivel_IdAndCodigoIsoStartingWith(Long id, String codigoIso);
}
