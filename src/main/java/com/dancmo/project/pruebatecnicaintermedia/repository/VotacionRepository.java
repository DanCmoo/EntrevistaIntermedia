package com.dancmo.project.pruebatecnicaintermedia.repository;

import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Votacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VotacionRepository extends JpaRepository<Votacion, UUID> {

}
