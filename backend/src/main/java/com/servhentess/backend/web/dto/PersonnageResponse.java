package com.servhentess.backend.web.dto;

import java.util.Map;

public record PersonnageResponse (
    String code,
    String nom,
    int niveau,
    String raceCode,
    String classeCode,
    Map<String, Integer> caracs,
    Map<String, Integer> caracsCombinees
){}
