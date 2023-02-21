package com.example.demo.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
@Data
@ToString
@Entity
@Table(name="note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="note_id")
    Integer id;
    String typenote;
    float note;

    @Column(name = "etudiant_id")
    Integer etudiantId;

    @MapsId("etudiantId")
    @ManyToOne
    @JoinColumn(name = "etudiant_id" ,nullable=false)
    private Etudiant etudiant = new Etudiant();


    @Column(name = "matiere_id")
    Integer matiereId;


    @MapsId("matiereId")
    @ManyToOne()
    @JoinColumn(name = "matiere_id" ,nullable=false)
    private Matiere matiere = new Matiere();

}
