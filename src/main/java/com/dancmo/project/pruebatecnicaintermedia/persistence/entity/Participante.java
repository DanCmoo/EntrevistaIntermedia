package com.dancmo.project.pruebatecnicaintermedia.persistence.entity;

import com.dancmo.project.pruebatecnicaintermedia.persistence.enums.TipoParticipante;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Enumerated(EnumType.STRING)
    private TipoParticipante tipo;

    @ElementCollection
    @CollectionTable(name = "participante_intervenciones",joinColumns = @JoinColumn(name = "participante_id"))
    @Column(name = "intervencion")
    private List<String> intervenciones = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "asamblea_participante",
            joinColumns = @JoinColumn(name = "participante_id"),
            inverseJoinColumns = @JoinColumn(name = "asamblea_id")
    )
    @JsonBackReference
    private List<Asamblea> asamblea = new ArrayList<>();

    public void addAsamblea(Asamblea asamblea) {
        this.asamblea.add(asamblea);
        asamblea.getParticipantes().add(this); // Agrega el participante en la asamblea
    }

}
