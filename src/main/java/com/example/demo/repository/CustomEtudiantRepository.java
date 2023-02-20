package com.example.demo.repository;
import com.example.demo.models.Etudiant;
import com.example.demo.models.Note;

import java.util.List;

public interface CustomEtudiantRepository {

    List<Etudiant> findEtudiantById(int id);


    List<Etudiant> findEtudiantbyFiliere(int id);


}
