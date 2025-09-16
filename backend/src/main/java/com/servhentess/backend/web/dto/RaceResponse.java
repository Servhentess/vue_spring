package com.servhentess.backend.web.dto;

import java.util.Map;

public class RaceResponse {
    private Long id;
    private String code;
    private String libelle;
    private String description;
    private Map<String, Object> caracs;

    public RaceResponse(Long id, String code, String libelle, String description, Map<String, Object> caracs) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.description = description;
        this.caracs = caracs;
    }

    public Long getId() { return id; }
    public String getCode() { return code; }
    public String getLibelle() { return libelle; }
    public String getDescription() { return description; }
    public Map<String, Object> getCaracs() { return caracs; }
}
