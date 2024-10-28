package com.dancmo.project.pruebatecnicaintermedia.persistence.entity;

import com.dancmo.project.pruebatecnicaintermedia.persistence.enums.EstadoIntervencion;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "intervenciones")
public class Intervencion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "intervencion_id")
    private UUID id;
    private String intervencion;
    @Enumerated(EnumType.STRING)
    private EstadoIntervencion estadoIntervencion;
}
