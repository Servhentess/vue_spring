package com.servhentess.backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servhentess.backend.domain.Race;
import com.servhentess.backend.repository.RaceRepository;
import com.servhentess.backend.web.dto.RaceResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RaceService {

    /********* Variables *********/
    private final RaceRepository repo;
    private final ObjectMapper mapper = new ObjectMapper();

    /********* Constructeur *********/
    public RaceService(RaceRepository repo) {
        this.repo = repo;
    }

    /********* Services *********/
    public List<RaceResponse> listAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public RaceResponse getByCodeOrThrow(String code) {
        Race r = repo.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("Race inconnue: " + code));
        return toResponse(r);
    }

    private RaceResponse toResponse(Race r) {
        Map<String, Object> caracs = parseJson(r.getCaracsJson());
        return new RaceResponse(r.getId(), r.getCode(), r.getLibelle(), r.getDescription(), caracs);
    }

    private Map<String, Object> parseJson(String json) {
        try {
            return mapper.readValue(json, new TypeReference<>() {});
        } catch (Exception e) {
            throw new IllegalStateException("Caracs JSON invalide pour la race", e);
        }
    }
}
