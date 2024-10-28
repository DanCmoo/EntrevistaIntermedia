package com.dancmo.project.pruebatecnicaintermedia.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "participantes")
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "participante_id",unique = true,nullable = false)
    private UUID id;
    @ElementCollection
    @CollectionTable(name = "participante_intervenciones",joinColumns = @JoinColumn(name = "participante_id"))
    @Column(name = "intervencion")
    private List<String> intervenciones;
    @ManyToMany
    @JoinTable(
            name = "asamblea_participante",
            joinColumns = @JoinColumn(name = "participante_id"),
            inverseJoinColumns = @JoinColumn(name = "asamblea_id")
    )
    private List<Asamblea> asamblea;

}
