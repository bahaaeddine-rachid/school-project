package com.example.demo.repository;

import com.example.demo.models.Proffesseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProffesseurRepository extends JpaRepository<Proffesseur, Integer> {
}