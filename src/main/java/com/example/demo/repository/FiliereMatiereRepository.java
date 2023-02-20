package com.example.demo.repository;

import com.example.demo.models.FiliereMatiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiliereMatiereRepository  extends JpaRepository<FiliereMatiere, Integer>, CustomFiliereMatiereRepository{
}
