package com.example.demo.repository;

import com.example.demo.models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NiveauRepository extends JpaRepository<Niveau, Integer>,CustomNiveauRepository {
}
