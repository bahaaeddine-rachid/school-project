package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="classe_id")
    Integer id;
    String nomclasse;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="classe_etudiant",
            joinColumns = @JoinColumn(name="classe_id"),
            inverseJoinColumns = @JoinColumn(name="etudiant_id"))
    private Set<Etudiant> etudiants;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="classe_proffesseur",
            joinColumns = @JoinColumn(name="classe_id"),
            inverseJoinColumns = @JoinColumn(name="proffesseur_id"))
    private Set<Proffesseur> proffesseurs;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="classe_matiere",
            joinColumns = @JoinColumn(name="classe_id"),
            inverseJoinColumns = @JoinColumn(name="matiere_id"))
    private Set<Matiere> matieres;


}
