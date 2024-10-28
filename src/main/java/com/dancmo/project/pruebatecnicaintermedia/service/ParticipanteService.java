package com.dancmo.project.pruebatecnicaintermedia.service;

import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Participante;
import com.dancmo.project.pruebatecnicaintermedia.presentation.model.ParticipanteDTO;

import java.util.List;
import java.util.UUID;

public interface ParticipanteService {
    UUID crearParticipante(ParticipanteDTO participanteDTO);
    List<Participante> listarParticipantes();
    boolean eliminarParticipante(UUID id);
}
