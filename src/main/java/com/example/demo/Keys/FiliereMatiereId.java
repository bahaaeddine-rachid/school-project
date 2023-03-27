package com.example.demo.Keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FiliereMatiereId implements Serializable {

    private static final long serialVersionUID = -5357721035043648119L;
    @Column(name="filiere_id")
    private  int filiereId;

@Column(name="matiere_id")
    private int matiereId;


    public FiliereMatiereId(int filiereId, int matiereId) {
        this.filiereId = filiereId;
        this.matiereId = matiereId;
    }

    public FiliereMatiereId() {
    }

    public int getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(int filiereId) {
        this.filiereId = filiereId;
    }

    public int getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(int matiereId) {
        this.matiereId = matiereId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiliereMatiereId that = (FiliereMatiereId) o;
        return filiereId == that.filiereId && matiereId == that.matiereId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filiereId, matiereId);
    }
}
