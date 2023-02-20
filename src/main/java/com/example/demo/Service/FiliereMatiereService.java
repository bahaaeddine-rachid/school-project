package com.example.demo.Service;

import com.example.demo.models.Etudiant;
import com.example.demo.models.FiliereMatiere;
import com.example.demo.repository.FiliereMatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiliereMatiereService {

    @Autowired
    FiliereMatiereRepository filiereMatiereRepository;

    public List<FiliereMatiere> findmatierebyfiliere(int id){

        return filiereMatiereRepository.findmatierebyfiliere(id);
    }

    public List<Integer> findAllniveau(){

        List<FiliereMatiere> filiereMatieres = filiereMatiereRepository.findAllNiveau();
        return filiereMatieres
                .stream()
                .map(FiliereMatiere::getNiveau)
                .collect(Collectors.toList());
    }

}
