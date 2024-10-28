package com.dancmo.project.pruebatecnicaintermedia.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoAsamblea {
    PROGRAMADA("Programada"),
    EN_PROGRESO("En progreso"),
    FINALIZADA("Finalizada");
    private final String estado;
}
