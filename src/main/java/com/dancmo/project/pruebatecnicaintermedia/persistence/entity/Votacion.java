package com.dancmo.project.pruebatecnicaintermedia.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "votaciones")
public class Votacion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "votacion_id")
    private UUID id;
    @OneToMany(mappedBy = "votacion", cascade = CascadeType.ALL)
    private List<Propuesta> propuestas;
    @ManyToOne
    @JoinColumn(name = "asamblea_id")
    private Asamblea asamblea;
}
