package com.marsa_maroc.gestion_des_prestation.controllers;

import com.marsa_maroc.gestion_des_prestation.entities.Transporteur;
import com.marsa_maroc.gestion_des_prestation.service.TransporteurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transporteurs")
@RequiredArgsConstructor

public class TransporteurController {

    private final TransporteurService transporteurService;

    @GetMapping
    public ResponseEntity<List<Transporteur>> getAllTransporteurs() {
        List<Transporteur> transporteurs = transporteurService.getAllTransporteurs();
        return ResponseEntity.ok(transporteurs);
    }

    @GetMapping("/{cin}")
    public ResponseEntity<Transporteur> getTransporteurById(@PathVariable String cin) {
        Transporteur transporteur = transporteurService.getTransporteurById(cin);
        return ResponseEntity.ok(transporteur);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Transporteur>> searchTransporteursByNom(@RequestParam String nomTransporteur) {
        List<Transporteur> transporteurs = transporteurService.searchTransporteursByNom(nomTransporteur);
        return ResponseEntity.ok(transporteurs);
    }

    @PostMapping
    public ResponseEntity<Transporteur> createTransporteur(@Valid @RequestBody Transporteur transporteur) {
        Transporteur savedTransporteur = transporteurService.createTransporteur(transporteur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransporteur);
    }

    @PutMapping("/{cin}")
    public ResponseEntity<Transporteur> updateTransporteur(@PathVariable String cin, @Valid @RequestBody Transporteur transporteur) {
        Transporteur updatedTransporteur = transporteurService.updateTransporteur(cin, transporteur);
        return ResponseEntity.ok(updatedTransporteur);
    }

    @DeleteMapping("/{cin}")
    public ResponseEntity<Void> deleteTransporteur(@PathVariable String cin) {
        transporteurService.deleteTransporteur(cin);
        return ResponseEntity.noContent().build();
    }
}