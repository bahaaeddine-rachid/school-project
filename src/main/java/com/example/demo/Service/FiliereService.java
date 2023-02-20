package com.example.demo.Service;

import com.example.demo.DTO.FiliereDTO;
import com.example.demo.models.Etudiant;
import com.example.demo.models.Filiere;
import com.example.demo.models.FiliereMatiere;
import com.example.demo.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiliereService {
    @Autowired
    FiliereRepository filiereRepository;

    public List<FiliereDTO> findAllFilieres(){
        List<FiliereDTO> filieres=filiereRepository.findAll()
                .stream()
                .map(FiliereDTO::new)
                .collect(Collectors.toList());

        return filieres;
    }
    public List<Integer> findAllFilieresid(){
        List<Filiere> filieres = filiereRepository.findAll();

        return filieres
                .stream()
                .map(Filiere::getId)
                .collect(Collectors.toList());
    }

}
