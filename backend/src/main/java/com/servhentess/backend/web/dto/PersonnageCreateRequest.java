package com.servhentess.backend.web.dto;

import java.util.Map;

public record PersonnageCreateRequest(
    String code,
    String nom,
    Integer niveau,
    String raceCode,
    String classeCode,
    Map<String, Integer> caracs 
) {}
