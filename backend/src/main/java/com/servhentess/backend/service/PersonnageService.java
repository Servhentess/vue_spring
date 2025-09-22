package com.servhentess.backend.service;

import com.servhentess.backend.domain.Personnage;
import com.servhentess.backend.repository.ClasseRepository;
import com.servhentess.backend.repository.PersonnageRepository;
import com.servhentess.backend.repository.RaceRepository;
import com.servhentess.backend.web.dto.PersonnageCreateRequest;
import com.servhentess.backend.web.dto.PersonnageResponse;
import com.servhentess.backend.web.error.BadRequestException;
import com.servhentess.backend.web.error.ConflictException;
import com.servhentess.backend.web.error.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonnageService {

    /********* Variables *********/
    private final ClasseRepository classeRepo;
    private final RaceRepository raceRepo;
    private final PersonnageRepository persoRepo;

    /********* Constructeur *********/
    public PersonnageService(ClasseRepository classeRepo, RaceRepository raceRepo, PersonnageRepository persoRepo){
        this.classeRepo = classeRepo;
        this.raceRepo = raceRepo;
        this.persoRepo = persoRepo;
    }

    /********* Services *********/

    /**
     * Création d'un personnage.
     * En base : on stocke uniquement les caracs propres du perso.
     * En réponse : on renvoie caracsPerso + caracsEffectives (perso + race + classe).
     */
    @Transactional
    public PersonnageResponse creer (PersonnageCreateRequest req) {
        // Validations basiques
        if (req == null) throw new BadRequestException("payload obligatoire");
        if (req.code() == null || req.code().isBlank()) throw new BadRequestException("code obligatoire");
        if (persoRepo.existsByCode(req.code())) throw new ConflictException("code déjà utilisé");
        if (req.niveau() == null || req.niveau() < 1) throw new BadRequestException("niveau doit être ≥ 1");
        if (req.raceCode() == null || req.raceCode().isBlank()) throw new BadRequestException("raceCode obligatoire");
        if (req.classeCode() == null || req.classeCode().isBlank()) throw new BadRequestException("classeCode obligatoire");
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
        p.setCaracs(req.caracs()); // ⚠️ caracs propres du perso (pas la somme)

        var saved = persoRepo.save(p);
        return toResponse(saved);
    }

    /**
     * Récupère un personnage par son code (slug).
     */
    @Transactional(readOnly = true)
    public PersonnageResponse getParCode(String code) {
        var p = persoRepo.findByCode(code)
                .orElseThrow(() -> new NotFoundException("Personnage non trouvé: " + code));
        return toResponse(p);
    }

    /**
     * Liste de tous les personnages.
     * Pour de gros volumes, ajouter une pagination (Pageable).
     */
    @Transactional(readOnly = true)
    public List<PersonnageResponse> listAll() {
        return persoRepo.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    /********* Helpers *********/

    /**
     * Construit la réponse API avec :
     * - caracsPerso = caracs propres du personnage (stockées en base)
     * - caracsEffectives = caracsPerso + caracsRace + caracsClasse
     */
    private PersonnageResponse toResponse(Personnage p) {
        Map<String, Integer> caracsPerso  = safeMap(p.getCaracs());
        Map<String, Integer> caracsRace   = p.getRace()   != null ? safeMap(p.getRace().getCaracs())   : Map.of();
        Map<String, Integer> caracsClasse = p.getClasse() != null ? safeMap(p.getClasse().getCaracs()) : Map.of();

        Map<String, Integer> caracsEffectives = addMaps(caracsPerso, caracsRace, caracsClasse);

        // ⚠️ Assure-toi que PersonnageResponse possède ces 2 blocs (voir record ci-dessous)
        return new PersonnageResponse(
                p.getCode(),
                p.getNom(),
                p.getNiveau(),
                p.getRace() != null ? p.getRace().getCode() : null,
                p.getClasse() != null ? p.getClasse().getCode() : null,
                caracsPerso,
                caracsEffectives
        );
    }

    /**
     * Additionne des maps clé→valeur (Integer), en considérant les clés absentes comme 0.
     * Ex: {"force":8} + {"force":2,"dex":1} = {"force":10,"dex":1}
     */
    @SafeVarargs
    private Map<String, Integer> addMaps(Map<String, Integer>... maps) {
        Map<String, Integer> out = new HashMap<>();
        if (maps == null) return out;
        for (Map<String, Integer> m : maps) {
            if (m == null) continue;
            for (var e : m.entrySet()) {
                out.merge(e.getKey(), e.getValue() == null ? 0 : e.getValue(), Integer::sum);
            }
        }
        return out;
    }

    private Map<String, Integer> safeMap(Map<String, Integer> m) {
        return (m == null) ? Map.of() : m;
    }
}
