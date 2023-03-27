package com.example.demo.repository;

import com.example.demo.models.FiliereMatiere;

import java.util.List;

public interface CustomFiliereMatiereRepository {
    List<FiliereMatiere> findmatierebyfiliere(int id, int niveau);

}
