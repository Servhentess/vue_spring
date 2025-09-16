package com.servhentess.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.servhentess.backend.domain.Race;
import java.util.Optional;

public interface RaceRepository extends JpaRepository<Race, Long> {
    Optional<Race> findByCode(String code);
}
