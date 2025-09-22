package com.servhentess.backend.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.servhentess.backend.domain.Classe;
import com.servhentess.backend.repository.ClasseRepository;
import com.servhentess.backend.web.dto.ClasseResponse;

@Service
public class ClasseService {

    /********* Variables *********/
    private final ClasseRepository repo;

    /********* Constructeur *********/
    public ClasseService (ClasseRepository repo) {
        this.repo = repo;
    }

    /********* Services *********/
    public List<ClasseResponse> listAll() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public ClasseResponse getByCodeOrThrow(String code) {
        Classe c = repo.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("Classe inconnue: " + code));
        return toResponse(c);
    }

    private ClasseResponse toResponse(Classe c) {
        Map<String, Integer> caracs = c.getCaracs();
        return new ClasseResponse(c.getId(), c.getCode(), c.getLibelle(), c.getDescription(), caracs);
    }
}
