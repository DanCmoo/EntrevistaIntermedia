package com.dancmo.project.pruebatecnicaintermedia.service.impl;

import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Asamblea;
import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Participante;
import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Votacion;
import com.dancmo.project.pruebatecnicaintermedia.persistence.enums.EstadoAsamblea;
import com.dancmo.project.pruebatecnicaintermedia.persistence.enums.TipoParticipante;
import com.dancmo.project.pruebatecnicaintermedia.presentation.model.AsambleaDTO;
import com.dancmo.project.pruebatecnicaintermedia.presentation.model.ParticipanteDTO;
import com.dancmo.project.pruebatecnicaintermedia.repository.AsambleaRepository;
import com.dancmo.project.pruebatecnicaintermedia.repository.ParticipanteRepository;
import com.dancmo.project.pruebatecnicaintermedia.service.AsambleaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AsambleaServiceImpl implements AsambleaService {
    private final AsambleaRepository asambleaRepository;
    private final ParticipanteRepository participanteRepository;
    public AsambleaServiceImpl(@Autowired AsambleaRepository asambleaRepository, @Autowired ParticipanteRepository participanteRepository, ParticipanteRepository participanteRepository1) {
        this.asambleaRepository = asambleaRepository;
        this.participanteRepository = participanteRepository1;
    }
    @Override
    public List<Asamblea> listarAsambleas() {

        return asambleaRepository.findAll();
    }

    @Override
    public Asamblea buscarAsamblea(UUID id) {
        return asambleaRepository.findById(id).orElse(null);
    }

    @Override
    public void insertarAsamblea(AsambleaDTO asambleaDTO) {
        Asamblea asamblea = new Asamblea();
        asamblea.setEstadoAsamblea(asambleaDTO.estadoAsamblea());
        asamblea.setTema(asambleaDTO.tema());
        asamblea.setFecha(asambleaDTO.fecha());
        asambleaRepository.save(asamblea);
    }

    @Override
    @Transactional
    public boolean actualizarEstadoAsamblea(UUID id, EstadoAsamblea estadoAsamblea) {
        return asambleaRepository.updateEstadoAsambleaById(id, estadoAsamblea)!=0;
    }

    @Override
    @Transactional
    public boolean eliminarAsamblea(UUID id) {
        Asamblea asamblea = asambleaRepository.findById(id).orElse(null);
        if(asamblea!=null) {
            asamblea.getParticipantes().forEach(participante -> participante.getAsamblea().remove(asamblea));
            asamblea.getParticipantes().clear();
            asambleaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UUID crearParticipanteAsamblea(UUID id, ParticipanteDTO participanteDTO) {
        Asamblea asamblea = asambleaRepository.findById(id).orElse(null);
        if(asamblea != null) {
            Participante participante = new Participante();
            participante.setTipo(participanteDTO.tipoParticipante());
            asamblea.addParticipante(participante);
            participanteRepository.save(participante);
            return participante.getId();
        }
        return null;
    }

    @Override
    public boolean insertarParticipanteAsamblea(ParticipanteDTO participanteDTO) {
        Asamblea asamblea = asambleaRepository.findById(participanteDTO.asambleaId()).orElse(null);
        Participante participante = participanteRepository.findById(participanteDTO.id()).orElse(null);
        if(asamblea != null && participante != null) {
            asamblea.addParticipante(participante);
            asambleaRepository.save(asamblea);
            return true;
        }
        return false;
    }


    @Override
    public List<Participante> listarParticipantes(UUID id) {
        Asamblea asamblea = asambleaRepository.findById(id).orElse(null);
        if(asamblea != null) {
            return asamblea.getParticipantes();
        }
        return null;
    }

    @Override
    public List<Votacion> listarVotaciones(UUID id) {
        Asamblea asamblea = asambleaRepository.findById(id).orElse(null);
        if(asamblea != null) {
            return asamblea.getVotaciones();
        }
        return null;
    }

    @Override
    public void eliminarParticipanteAsamblea(UUID id, UUID participanteId) {
        Asamblea asamblea = asambleaRepository.findById(id).orElse(null);
        if(asamblea != null) {
            List<Participante> participantes = asamblea.getParticipantes();
            Participante participante = participanteRepository.findById(participanteId).orElse(null);
            if(participante != null) {
                participantes.remove(participante);
            }
        }
    }

    @Override
    public Participante buscarParticipanteAsamblea(UUID id, UUID participanteId) {
        Asamblea asamblea = asambleaRepository.findById(id).orElse(null);
        if(asamblea != null) {
            return participanteRepository.findById(participanteId).orElse(null);
        }
        return null;
    }
}
