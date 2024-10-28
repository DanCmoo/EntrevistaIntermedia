package com.dancmo.project.pruebatecnicaintermedia.persistence.entity;

import com.dancmo.project.pruebatecnicaintermedia.persistence.enums.EstadoAsamblea;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "asambleas")
public class Asamblea {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "asamblea_id",unique = true, nullable = false)
    private UUID id;
    private Date fecha;
    private String tema;
    @Enumerated(EnumType.STRING)
    private EstadoAsamblea estadoAsamblea;
    @ManyToMany(mappedBy = "asamblea")
    private List<Participante> participantes;
    @OneToMany(mappedBy = "asamblea",cascade = CascadeType.ALL)
    private List<Votacion> votaciones;


}
