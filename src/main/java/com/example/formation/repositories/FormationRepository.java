package com.example.formation.repositories;

import com.example.formation.entites.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation,Long> {
}
