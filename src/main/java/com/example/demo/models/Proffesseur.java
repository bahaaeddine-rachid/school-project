package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
@Table(name="proffesseur")
public class Proffesseur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="proffesseur_id")
    Integer id;
    String nomprof;
    String premonprof;
    String Datedenaissance;



    @JsonIgnore
    @OneToMany(mappedBy = "proffesseur")
    Set<Matiere> matieres;


}
