package com.example.demo.models;


import com.example.demo.DTO.MatiereDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@ToString
@Table(name="matiere")
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="matiere_id")
    Integer id;
    String nommatiere;


    public Matiere(MatiereDTO matiere) {
        this.id = matiere.getId();
        this.nommatiere = matiere.getNommatiere();
    }

    public Matiere(Matiere matiere) {
        this.id=matiere.getId();
        this.nommatiere=matiere.getNommatiere();
    }


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "proffesseur_id" ,nullable=false)
    private Proffesseur proffesseur;


}
