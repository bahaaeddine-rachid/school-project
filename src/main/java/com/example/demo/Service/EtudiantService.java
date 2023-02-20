package com.example.demo.Service;

import com.example.demo.DTO.EtudiantDTO;
import com.example.demo.models.Etudiant;

import com.example.demo.models.Filiere;
import com.example.demo.models.Note;
import com.example.demo.repository.EtudiantRepository;

import com.example.demo.repository.FiliereRepository;
import com.example.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    FiliereRepository filiereRepository;


    public List<Etudiant> findAllEtudiants(){
        return etudiantRepository.findAll();
    }


    public List<Etudiant> findEtudiantByID(int id){

        return etudiantRepository.findEtudiantById(id);
    }

    public Etudiant save(EtudiantDTO etudiant){

        Filiere filiere=filiereRepository.findById(etudiant.getFiliereId()).orElse(null);
        Etudiant etu=new Etudiant();
        if(filiere!=null){
            etu=new Etudiant(etudiant);
            etu.setFiliere(filiere);
            etudiantRepository.save(etu);
        }
        return etu;
    }


    public List<Etudiant> findEtudiantbyFiliere(int id){

            return etudiantRepository.findEtudiantbyFiliere(id);
    }


    public void deleteEtudiant(int id){
        etudiantRepository.deleteById(id);
    }




}
