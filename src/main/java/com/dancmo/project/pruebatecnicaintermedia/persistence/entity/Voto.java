package com.dancmo.project.pruebatecnicaintermedia.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "votos")
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "voto_id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "propuesta_id")
    private Propuesta propuesta;

}
