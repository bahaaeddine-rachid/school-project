package com.example.demo.Service;

import com.example.demo.models.FiliereMatiere;
import com.example.demo.models.Niveau;
import com.example.demo.repository.FiliereMatiereRepository;
import com.example.demo.repository.FiliereRepository;
import com.example.demo.repository.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereMatiereService {

    @Autowired
    FiliereMatiereRepository filiereMatiereRepository;
    @Autowired
    private FiliereRepository filiereRepository;
    @Autowired
    private NiveauRepository niveauRepository;

    public List<FiliereMatiere> findmatierebyfiliere(int id, int niveau){

        return filiereMatiereRepository.findmatierebyfiliere(id,niveau);
    }




}
