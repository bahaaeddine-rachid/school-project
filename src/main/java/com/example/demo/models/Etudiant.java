package com.example.demo.models;

import com.example.demo.DTO.EtudiantDTO;
import lombok.Data;


import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Entity
@Table(name="etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="etudiant_id")
    Integer id;
    String nom;
    String prenom;
    String datedenaissance;
    String sexe;

    @Column(name = "filiere_id")
    Integer FiliereId;

    @MapsId("filiereId")
    @ManyToOne
    @JoinColumn(name = "filiere_id" ,nullable=false)
    public Filiere filiere = new Filiere();



    public Etudiant(EtudiantDTO etudiant) {

        this.nom = etudiant.getNom();
        this.prenom = etudiant.getPrenom();
        this.datedenaissance=etudiant.getDatedenaissance();
        this.sexe = etudiant.getSexe();
    }

    public Etudiant() {
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", datedenaissance='" + datedenaissance + '\'' +
                ", sexe='" + sexe + '\'' +
                ", filiere=" + filiere +
                '}';
    }
}
