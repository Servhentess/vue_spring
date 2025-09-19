package com.servhentess.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servhentess.backend.domain.Personnage;

public interface PersonnageRepository extends JpaRepository<Personnage, Long>{
    Optional<Personnage> findByCode(String code);
    boolean existsByCode(String code);
}
