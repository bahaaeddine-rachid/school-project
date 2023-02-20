package com.example.demo.models;

import javax.persistence.ManyToMany;
import java.util.List;

public class EtudiantClasse {


    @ManyToMany(mappedBy = "etudiants")
    List<Classe> classes ;
}
