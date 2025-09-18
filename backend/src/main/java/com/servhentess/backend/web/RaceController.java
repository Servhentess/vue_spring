package com.servhentess.backend.web;

import com.servhentess.backend.service.RaceService;
import com.servhentess.backend.web.dto.RaceResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/races")
public class RaceController {

    /********* Variables *********/
    private final RaceService service;

    /********* Constructeur *********/
    public RaceController(RaceService service) {
        this.service = service;
    }

    /********* Controle *********/
    @GetMapping
    public List<RaceResponse> list() {
        return service.listAll();
    }

    @GetMapping("/{code}")
    public RaceResponse byCode(@PathVariable String code) {
        return service.getByCodeOrThrow(code);
    }
}
