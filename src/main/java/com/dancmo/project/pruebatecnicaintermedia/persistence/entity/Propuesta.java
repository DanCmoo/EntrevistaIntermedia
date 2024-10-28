package com.dancmo.project.pruebatecnicaintermedia.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "propuestas")
public class Propuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "propuesta_id")
    private UUID id;
    @OneToMany(mappedBy = "propuesta",cascade = CascadeType.ALL)
    private List<Voto> votos;
    @ManyToOne
    @JoinColumn(name = "votacion_id")
    private Votacion votacion;

}
