package com.dancmo.project.pruebatecnicaintermedia.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoIntervencion {
    APROBADO("Aprobado"),
    RECHAZADO("Rechazado"),
    EN_ESPERA("En espera");
    private String estado;
}
