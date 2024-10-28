package com.dancmo.project.pruebatecnicaintermedia.presentation.controller;

import com.dancmo.project.pruebatecnicaintermedia.persistence.entity.Asamblea;
import com.dancmo.project.pruebatecnicaintermedia.presentation.model.AsambleaDTO;
import com.dancmo.project.pruebatecnicaintermedia.service.AsambleaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/asamblea")
public class AsambleaController {
    AsambleaService asambleaService;
    public AsambleaController(@Autowired AsambleaService asambleaService) {
        this.asambleaService = asambleaService;
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
    @PostMapping("/crearAsamblea")
    public ResponseEntity<Boolean> crearAsamblea(@RequestBody AsambleaDTO asambleaDTO) {
        asambleaService.insertarAsamblea(asambleaDTO);
        return ResponseEntity.ok(true);
    }

}
