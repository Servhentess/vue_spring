package com.servhentess.backend.web.dto;

import java.util.Map;

public class RaceResponse {
    /********* Variables *********/
    private Long id;
    private String code;
    private String libelle;
    private String description;
    private Map<String, Integer> caracs;

    /********* Constructeur *********/
    public RaceResponse(Long id, String code, String libelle, String description, Map<String, Integer> caracs) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.description = description;
        this.caracs = caracs;
    }

    /********* Guetter *********/
    public Long getId() { return id; }
    public String getCode() { return code; }
    public String getLibelle() { return libelle; }
    public String getDescription() { return description; }
    public Map<String, Integer> getCaracs() { return caracs; }
}
