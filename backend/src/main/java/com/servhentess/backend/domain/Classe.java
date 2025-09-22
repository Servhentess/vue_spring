package com.servhentess.backend.domain;

import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;

@Entity
@Table(name = "classes")
public class Classe {
    /*********Identification column *********/
    // Colonne ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // Colonne CODE
    @Column(name = "code", nullable = false, unique = true, length = 50)
    private String code;

    // Colonne libelle
    @Column(name = "libelle", nullable = false, length = 100)
    private String libelle;

    // Colonne Description
    @Column(name = "description")
    private String description;

    // Colonne caracs
    @Column(name = "caracs", nullable = false, columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Integer> caracs;

    /********* Constructeur *********/
    public Classe(){}

    public Classe(String code, String libelle, String description, Map<String, Integer> caracs) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
        this.caracs = caracs;
    }

    /*********Guetter and Setter *********/
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Map<String, Integer> getCaracs() { return caracs; }
    public void setCaracs(Map<String, Integer> caracs) { this.caracs = caracs; }
}
