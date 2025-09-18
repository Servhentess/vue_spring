package com.servhentess.backend.web.dto;

import java.util.Map;

public class ClasseResponse {
    /********* Variables *********/
    private Long id;
    private String code;
    private String libelle;
    private String description;
    private Map<String, Object> caracs;

    /********* Constructeur *********/
    public ClasseResponse(Long id, String code, String libelle, String description, Map<String, Object> caracs){
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.description = description;
        this.caracs = caracs;
    }

    /********* Guetter *********/
    public Long getId() {return id;}
    public String getCode() {return code;}
    public String getLibelle() {return libelle;}
    public String getDescription() {return description;}
    public Map<String, Object> getCaracs() {return caracs;}
}