package com.dancmo.project.pruebatecnicaintermedia.repository;

import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Asamblea;
import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Participante;
import com.dancmo.project.pruebatecnicaintermedia.persistence.enums.EstadoAsamblea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface AsambleaRepository extends JpaRepository<Asamblea, UUID> {
    @Modifying
    @Query("UPDATE Asamblea u SET u.estadoAsamblea = :estado WHERE u.id = :id")
    void updateEstadoAsambleaById(@Param(value = "id") UUID id,@Param(value = "estado") EstadoAsamblea estado);
    @Modifying
    @Query("UPDATE Asamblea u SET u.participantes = :participantes WHERE u.id =:id")
    void updateParticipantesAsambleaById(@Param(value = "id") UUID id,@Param(value = "participantes") List<Participante> participantes);

}
