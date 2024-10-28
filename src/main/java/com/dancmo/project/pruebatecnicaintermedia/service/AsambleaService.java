package com.dancmo.project.pruebatecnicaintermedia.service;

import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Asamblea;
import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Participante;
import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Votacion;
import com.dancmo.project.pruebatecnicaintermedia.persistence.enums.EstadoAsamblea;
import com.dancmo.project.pruebatecnicaintermedia.presentation.model.AsambleaDTO;

import java.util.List;
import java.util.UUID;

public interface AsambleaService {
    List<Asamblea> listarAsambleas();
    Asamblea buscarAsamblea(UUID id);
    void insertarAsamblea(AsambleaDTO asambleaDTO);
    void actualizarEstadoAsamblea(UUID id, EstadoAsamblea estadoAsamblea);
    void eliminarAsamblea(UUID id);
    void insertarParticipanteAsamblea(UUID id, Participante participante);
    void eliminarParticipanteAsamblea(UUID id, UUID participanteId);
    Participante buscarParticipanteAsamblea(UUID id,UUID participanteId);
    List<Participante> listarParticipantes(UUID id);
    List<Votacion> listarVotaciones(UUID id);

}
