package com.servhentess.backend.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servhentess.backend.service.PersonnageService;
import com.servhentess.backend.web.dto.PersonnageCreateRequest;
import com.servhentess.backend.web.dto.PersonnageResponse;

@RestController
@RequestMapping("/api/personnages")
public class PersonnageController {
    /********* Variables *********/
    private PersonnageService service;

    /********* Constructeur *********/
    public PersonnageController(PersonnageService service) {
        this.service = service;
    }

    /********* Controles *********/
    // Creation personnage
    @PostMapping
    public ResponseEntity<PersonnageResponse> creer (@RequestBody PersonnageCreateRequest req){
        return ResponseEntity.ok(service.creer(req));
    }

    // Recuperer personnage par code
    @GetMapping("/{code}")
    public ResponseEntity<PersonnageResponse> get(@PathVariable String code) {
        return ResponseEntity.ok(service.getParCode(code));
    }
}
