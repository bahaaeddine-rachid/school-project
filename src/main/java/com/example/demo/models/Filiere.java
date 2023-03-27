package com.example.demo.models;

import com.example.demo.DTO.FiliereDTO;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
@Table(name = "filiere")
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "filiere_id")
    Integer id;
    String nomfiliere;
    String abreviation;

    public Filiere(FiliereDTO filiere) {
        this.id = filiere.getId();
        this.nomfiliere = filiere.getNomfiliere();
        this.abreviation = filiere.getAbreviation();

    }


    @Override
    public String toString() {
        return "Filiere{" +
                "id=" + id +
                ", nomfiliere='" + nomfiliere + '\'' +
                ", abreviation='" + abreviation + '\'' +
                '}';
    }

}
