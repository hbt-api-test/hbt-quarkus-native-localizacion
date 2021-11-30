package com.quarkus.cache.localizacion.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "TEGE_PARAM_ESTRUCTGEOGRAF")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParametrizacionGeografica implements Serializable {

    /*** Atributo que determina el id de parametrización de la estructura geográfica*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EGEID")
    private Long id;

    /*** Atributo que determina el número del Nivel en la parametrización geográfica*/
    @Column(name = "EGEIDNIVEL")
    private Long idNivel;

    /*** Atributo que determina el nombre del nivel en la parametrización geográfica*/
    @Column(name = "EGEDSNOMBRENIVEL")
    private String nombreNivel;

    /*** Atributo que contiene la descripción de la parametrización geográfica*/
    @Column(name = "EGEDSDESCRIPCIONNIVEL")
    private String descripcion;

    /*** Atributo que contiene el estado de la parametrización geográfica*/
    //private EstadoNivelGeograficoEnum estadoNivel;

    /*** Atributo que contiene fechaCreacion geográfica*/
    @Column(name = "EGEFECREACION")
    private LocalDateTime fechaCreacion;
    /*** Atributo que contiene usuarioCreacion geográfica*/
    @Column(name = "EGECDUSUARIOCREACION")
    private String usuarioCreacion;
    /*** Atributo que contiene  fechaModificacion geográfica*/
    @Column(name = "EGEFEMODIFICACION")
    private LocalDateTime fechaModificacion;
    /*** Atributo que contiene usuarioModificacion geográfica*/
    @Column(name = "EGECDUSUARIOMODIFICA")
    private String usuarioModificacion;

}
