package com.dancmo.project.pruebatecnicaintermedia.service.impl;

import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Participante;
import com.dancmo.project.pruebatecnicaintermedia.presentation.model.ParticipanteDTO;
import com.dancmo.project.pruebatecnicaintermedia.repository.ParticipanteRepository;
import com.dancmo.project.pruebatecnicaintermedia.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipanteServiceImpl implements ParticipanteService {

    private final ParticipanteRepository participanteRepository;
    public ParticipanteServiceImpl(@Autowired ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }
    @Override
    public UUID crearParticipante(ParticipanteDTO participanteDTO) {
        Participante participante = new Participante();
        participante.setTipo(participanteDTO.tipoParticipante());
        participanteRepository.save(participante);
        return participante.getId();
    }

    @Override
    public List<Participante> listarParticipantes() {
        return participanteRepository.findAll();
    }

    @Override
    public boolean eliminarParticipante(UUID id) {
        Participante participante = participanteRepository.findById(id).orElse(null);
        if(participante != null) {
            participante.getAsamblea().forEach(asamblea -> asamblea.getParticipantes().remove(participante));
            participante.getAsamblea().clear();
            participanteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
