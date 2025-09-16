package com.servhentess.backend.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // BIGSERIAL
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code", nullable = false, unique = true, length = 50)
    private String code;

    @Column(name = "libelle", nullable = false, length = 100)
    private String libelle;

    @Column(name = "description")
    private String description;

    // JSONB stocké tel quel. On le parsera côté service pour l'API.
    @Column(name = "caracs", nullable = false, columnDefinition = "jsonb")
    private String caracsJson;

    // Getters/Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCaracsJson() { return caracsJson; }
    public void setCaracsJson(String caracsJson) { this.caracsJson = caracsJson; }
}