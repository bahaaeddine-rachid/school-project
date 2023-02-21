package com.example.demo.Service;

import com.example.demo.models.Niveau;
import com.example.demo.repository.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauService {

@Autowired
    NiveauRepository niveauRepository;
    public List<Niveau> findAllNiveau(){
        return niveauRepository.findAll();
    }

}
