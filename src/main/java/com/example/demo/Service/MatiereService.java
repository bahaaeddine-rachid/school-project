package com.example.demo.Service;

import com.example.demo.models.Etudiant;
import com.example.demo.models.Matiere;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {

    @Autowired
    private MatiereRepository matiereRepository;


    public List<Matiere> findAllMatieres(){
        return matiereRepository.findAll();
    }

}
