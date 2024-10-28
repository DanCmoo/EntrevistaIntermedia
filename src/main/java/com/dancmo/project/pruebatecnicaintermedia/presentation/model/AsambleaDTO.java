package com.dancmo.project.pruebatecnicaintermedia.presentation.model;

import com.dancmo.project.pruebatecnicaintermedia.persistence.enums.EstadoAsamblea;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public record AsambleaDTO(
        @JsonProperty("fecha") Date fecha,
        @JsonProperty("tema") String tema,
        @JsonProperty("estado") EstadoAsamblea estadoAsamblea
) {
}
