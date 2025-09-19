package com.servhentess.backend.domain;

import java.time.Instant;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;

@Entity
@Table(
    name = "personnages",
    uniqueConstraints = @UniqueConstraint(name = "uk_personnage_code", columnNames = "code")
)
public class Personnage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60, unique = true)
    private String code;

    @Column(nullable = false, length = 120)
    private String nom;

    @Column(nullable = false)
    private int niveau = 1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classe_id", nullable = false)
    private Classe classe;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", nullable = false)
    private Map<String, Integer> caracs;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();
    
    /********* Getter and Setter *********/
    public Long getId() { return id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getNiveau() { return niveau; }
    public void setNiveau(int niveau) { this.niveau = niveau; }
    public Race getRace() { return race; }
    public void setRace(Race race) { this.race = race; }
    public Classe getClasse() { return classe; }
    public void setClasse(Classe classe) { this.classe = classe; }
    public Map<String, Integer> getCaracs() { return caracs; }
    public void setCaracs(Map<String, Integer> caracs) { this.caracs = caracs; }
    public Instant getCreatedAt() { return createdAt; }
}
