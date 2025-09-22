package com.servhentess.backend.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

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

    /**
     * Caractéristiques de la race, stockées en JSONB.
     * Exemple :
     * {
     *   "force": 1,
     *   "dex": 2,
     *   "int": 0,
     *   "endu": 1,
     *   "cha": -1
     * }
     */
    @Column(name = "caracs", nullable = false, columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Integer> caracs;

    // --------- Constructeurs ---------

    protected Race() {
        // requis par JPA
    }

    public Race(String code, String libelle, String description, Map<String, Integer> caracs) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
        this.caracs = caracs;
    }

    // --------- Getters / Setters ---------

    public Long getId() { return id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Map<String, Integer> getCaracs() { return caracs; }
    public void setCaracs(Map<String, Integer> caracs) { this.caracs = caracs; }
}
