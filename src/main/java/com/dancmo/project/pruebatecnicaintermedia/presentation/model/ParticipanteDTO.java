package com.dancmo.project.pruebatecnicaintermedia.presentation.model;

import com.dancmo.project.pruebatecnicaintermedia.persistence.enums.TipoParticipante;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ParticipanteDTO(
        @JsonProperty("id") UUID id,
        @JsonProperty("asambleaId") UUID asambleaId,
        @JsonProperty("tipo") TipoParticipante tipoParticipante
) {
}
