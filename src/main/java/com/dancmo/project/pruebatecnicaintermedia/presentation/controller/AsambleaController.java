package com.dancmo.project.pruebatecnicaintermedia.presentation.controller;

import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Asamblea;
import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Participante;
import com.dancmo.project.pruebatecnicaintermedia.persistence.enums.EstadoAsamblea;
import com.dancmo.project.pruebatecnicaintermedia.presentation.model.AsambleaDTO;
import com.dancmo.project.pruebatecnicaintermedia.presentation.model.ParticipanteDTO;
import com.dancmo.project.pruebatecnicaintermedia.service.AsambleaService;
import com.dancmo.project.pruebatecnicaintermedia.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/asamblea")
public class AsambleaController {

    private final AsambleaService asambleaService;
    private final ParticipanteService participanteService;
    public AsambleaController(@Autowired AsambleaService asambleaService, @Autowired ParticipanteService participanteService) {
        this.asambleaService = asambleaService;
        this.participanteService = participanteService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Asamblea>> listarAsambleas() {
        List<Asamblea> asambleas = asambleaService.listarAsambleas();
        if (!asambleas.isEmpty()) {
            return ResponseEntity.ok(asambleas);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Asamblea> buscarAsambleaPorId(@PathVariable UUID id) {
        Asamblea asamblea = asambleaService.buscarAsamblea(id);
        if (asamblea != null) {
            return ResponseEntity.ok(asamblea);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/crear")
    public ResponseEntity<Boolean> crearAsamblea(@RequestBody AsambleaDTO asambleaDTO) {
        asambleaService.insertarAsamblea(asambleaDTO);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Boolean> eliminarAsamblea(@PathVariable UUID id) {
        boolean eliminado = asambleaService.eliminarAsamblea(id);
        return ResponseEntity.ok(eliminado);
    }

    @PutMapping("estado/{id}")
    public ResponseEntity<Boolean> actualizarEstadoAsamblea(@PathVariable UUID id, @RequestBody AsambleaDTO asambleaDTO){
        boolean actualizado = asambleaService.actualizarEstadoAsamblea(id,asambleaDTO.estadoAsamblea());
        return ResponseEntity.ok(actualizado);

    }

    @PostMapping("/crearParticipante/{id}")
    public ResponseEntity<UUID> crearParticipanteAsamblea(@PathVariable UUID id, @RequestBody ParticipanteDTO participanteDTO){
        UUID participanteId = asambleaService.crearParticipanteAsamblea(id,participanteDTO);
        return ResponseEntity.ok(participanteId);
    }

    @PostMapping("/crearParticipante")
    public ResponseEntity<UUID> crearParticipante(@RequestBody ParticipanteDTO participanteDTO){
        UUID participanteId = participanteService.crearParticipante(participanteDTO);
        return ResponseEntity.ok(participanteId);
    }

    @GetMapping("/participante/listar")
    public ResponseEntity<List<Participante>> listarParticipantes() {
        List<Participante> participantes = participanteService.listarParticipantes();
        if(!participantes.isEmpty()){
            return ResponseEntity.ok(participantes);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/participante/{id}")
    public ResponseEntity<Boolean> eliminarParticipante(@PathVariable UUID id) {
        boolean eliminado = participanteService.eliminarParticipante(id);
        return ResponseEntity.ok(eliminado);
    }

    @PutMapping("/asignarParticipante")
    public ResponseEntity<Boolean> insertarParticipante(@RequestBody ParticipanteDTO participanteDTO){
        boolean insertado = asambleaService.insertarParticipanteAsamblea(participanteDTO);
        return ResponseEntity.ok(insertado);

    }

}
