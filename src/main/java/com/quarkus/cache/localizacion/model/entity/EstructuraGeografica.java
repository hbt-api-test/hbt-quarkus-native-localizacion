package com.quarkus.cache.localizacion.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TEGE_PARAM_UBICACIGEOGRAF")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstructuraGeografica implements Serializable {


    @Id
    @Column(name = "GEGID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*** Atributo que determina el código de la ubicación geográfica */
    @Column(name = "GEGCDCODIGOUBICACION")
    private String codigoUbicacion;

    /*** Atributo que contiene el nombre de la ubicacion geográfica */
    @Column(name = "GEGDSNOMBREUBICACION")
    private String nombreUbicacion;

    /*** Atributo que contiene el indicativo telefonico de la ubicación geográfica */
    @Column(name = "GEGCDTELEFLARGADIST")
    private String codigoTelefonicoLargaDistancia;

    /*** Atributo que contiene el código iso de la ubicación geográfica */
    @Column(name = "GEGCDCODIGOISO")
    private String codigoIso;

    /*** Atributo que determina la ubicación del padre */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GEGIDUBICACIONPADRE")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private EstructuraGeografica ubicacionPadre;

    /***
     * Atributo que determina el número del Nivel en la parametrización geográfica
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GEGIDNIVEL")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ParametrizacionGeografica nivel;

    /*** Atributo que contiene fechaCreacion de la ubicación geográfica */
    @Column(name = "GEGFECREACION")
    private LocalDateTime fechaCreacion;
    /*** Atributo que contiene usuarioCreacion de la ubicación geográfica */
    @Column(name = "GEGCDUSUARIOCREACION")
    private String usuarioCreacion;
    /*** Atributo que contiene fechaModificacion de la ubicación geográfica */
    @Column(name = "GEGFEMODIFICACION")
    private LocalDateTime fechaModificacion;
    /*** Atributo que contiene usuarioModificacion de la ubicación geográfica */
    @Column(name = "GEGCDUSUARIOMODIFICA")
    private String usuarioModificacion;

}
