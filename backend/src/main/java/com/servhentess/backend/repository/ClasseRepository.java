package com.servhentess.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servhentess.backend.domain.Classe;


public interface ClasseRepository extends JpaRepository <Classe, Long> {
    Optional<Classe> findByCode(String code);    
}
