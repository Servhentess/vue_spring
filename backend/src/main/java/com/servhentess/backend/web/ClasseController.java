package com.servhentess.backend.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servhentess.backend.service.ClasseService;
import com.servhentess.backend.web.dto.ClasseResponse;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/classes")
public class ClasseController {
    /********* Variables *********/
    private final ClasseService service;

    /********* Constructeur *********/
    public ClasseController(ClasseService service) {
        this.service = service;
    }

    /********* Controle *********/
    @GetMapping
    public List<ClasseResponse> list() {
        return service.listAll();
    }
    
    @GetMapping("/{code}")
    public ClasseResponse byCode(@PathVariable String code){
        return service.getByCodeOrThrow(code);
    }
}
