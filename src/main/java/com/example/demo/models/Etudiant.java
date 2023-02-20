package com.example.demo.models;

import com.example.demo.DTO.EtudiantDTO;
import lombok.Data;


import javax.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "filiere_id" ,nullable=false)
    public Filiere filiere = new Filiere();

    public Etudiant(EtudiantDTO etudiant) {
        this.id = etudiant.getId();
        this.nom = etudiant.getNom();
        this.prenom = etudiant.getPrenom();
        this.datedenaissance = etudiant.getDateNaissance();
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
