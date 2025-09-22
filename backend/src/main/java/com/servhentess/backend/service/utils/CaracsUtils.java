package com.servhentess.backend.service.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Utilitaires pour additionner les caractéristiques.
 */
public final class CaracsUtils {
    private CaracsUtils() {}

    /**
     * Somme clé par clé, en considérant les clés absentes comme 0.
     * Ex: {"force":8} + {"force":2,"dex":1} = {"force":10,"dex":1}
     */
    @SafeVarargs
    public static Map<String, Integer> add(Map<String, Integer>... maps) {
        Map<String, Integer> out = new HashMap<>();
        if (maps == null) return out;
        for (Map<String, Integer> m : maps) {
            if (m == null) continue;
            for (var e : m.entrySet()) {
                out.merge(e.getKey(), safe(e.getValue()), Integer::sum);
            }
        }
        return out;
    }

    private static int safe(Integer v) { return v == null ? 0 : v; }
}
