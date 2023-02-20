package com.example.demo.models;


import com.example.demo.Keys.FiliereMatiereId;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "filiere_matiere")
public class FiliereMatiere {

@EmbeddedId
FiliereMatiereId id;

@MapsId("filiereId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filiere_id")
    Filiere filiere;

    @MapsId("matiereId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="matiere_id")
    Matiere matiere;

    Integer niveau ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiliereMatiere that = (FiliereMatiere) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
