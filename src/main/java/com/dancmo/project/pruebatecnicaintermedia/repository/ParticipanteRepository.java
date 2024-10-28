package com.dancmo.project.pruebatecnicaintermedia.repository;

import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface ParticipanteRepository extends JpaRepository<Participante, UUID> {


}
