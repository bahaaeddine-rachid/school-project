package com.example.demo.repository;

import com.example.demo.models.Etudiant;
import com.example.demo.models.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>, CustomEtudiantRepository {

}
