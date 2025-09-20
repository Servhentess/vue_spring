package com.servhentess.backend.service;

import org.springframework.stereotype.Service;

import com.servhentess.backend.domain.Personnage;
import com.servhentess.backend.repository.ClasseRepository;
import com.servhentess.backend.repository.PersonnageRepository;
import com.servhentess.backend.repository.RaceRepository;
import com.servhentess.backend.web.dto.PersonnageCreateRequest;
import com.servhentess.backend.web.dto.PersonnageResponse;
import com.servhentess.backend.web.error.BadRequestException;
import com.servhentess.backend.web.error.ConflictException;
import com.servhentess.backend.web.error.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonnageService {
    /********* Variables *********/
    private ClasseRepository classeRepo;
    private RaceRepository raceRepo;
    private PersonnageRepository persoRepo;

    /********* Constructeur *********/
    public PersonnageService(ClasseRepository classeRepo, RaceRepository raceRepo, PersonnageRepository persoRepo){
        this.classeRepo = classeRepo;
        this.raceRepo = raceRepo;
        this.persoRepo = persoRepo;
    }

    /********* Services *********/
    @Transactional
    public PersonnageResponse creer (PersonnageCreateRequest req) {
        // Validations basiques
        if (req.code() == null || req.code().isBlank()) throw new BadRequestException("code obligatoire");
        if (persoRepo.existsByCode(req.code())) throw new ConflictException("code déjà utilisé");
        if (req.niveau() == null || req.niveau() < 1) throw new BadRequestException("niveau doit être ≥ 1");
        if (req.caracs() == null || req.caracs().isEmpty()) throw new BadRequestException("caracs obligatoires");

        var race = raceRepo.findByCode(req.raceCode())
                .orElseThrow(() -> new BadRequestException("Race inconnue: " + req.raceCode()));

        var classe = classeRepo.findByCode(req.classeCode())
                .orElseThrow(() -> new BadRequestException("Classe inconnue: " + req.classeCode()));

        var p = new Personnage();
        p.setCode(req.code());
        p.setNom(req.nom());
        p.setNiveau(req.niveau());
        p.setRace(race);
        p.setClasse(classe);
        p.setCaracs(req.caracs());

        var saved = persoRepo.save(p);
        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public PersonnageResponse getParCode(String code) {
        var p = persoRepo.findByCode(code)
                .orElseThrow(() -> new NotFoundException("Personnage non trouvé: " + code));
        return toResponse(p);
    }

    private PersonnageResponse toResponse(Personnage p) {
        return new PersonnageResponse(
                p.getCode(),
                p.getNom(),
                p.getNiveau(),
                p.getRace().getCode(),
                p.getClasse().getCode(),
                p.getCaracs()
        );
    }
}