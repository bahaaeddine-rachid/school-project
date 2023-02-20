package com.example.demo.models;

import javax.persistence.ManyToMany;
import java.util.List;

public class ProffesseurClasse {
    @ManyToMany(mappedBy = "proffesseurs")
    private List<Classe> classes;

}
