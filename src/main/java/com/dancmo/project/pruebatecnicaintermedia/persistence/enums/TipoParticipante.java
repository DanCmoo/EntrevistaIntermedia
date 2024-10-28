package com.dancmo.project.pruebatecnicaintermedia.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoParticipante {
    ESTUDIANTE("Estudiante"),
    PROFESOR("Profesor"),
    ADMINISTRATIVO("Administrativo");
    private String tipo;
}
