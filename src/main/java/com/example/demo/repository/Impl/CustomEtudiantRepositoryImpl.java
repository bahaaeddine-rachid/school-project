package com.example.demo.repository.Impl;

import com.example.demo.models.*;
import com.example.demo.repository.CustomEtudiantRepository;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Slf4j
public class CustomEtudiantRepositoryImpl implements CustomEtudiantRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Etudiant> findEtudiantById(int id){
        QEtudiant qEtudiant=QEtudiant.etudiant;
        return new JPAQuery<Etudiant>(em)
                .select(qEtudiant)
                .from(qEtudiant)
                .where(qEtudiant.id.eq(id))
                .fetch();
    }

    @Override
    public List<Etudiant> findEtudiantbyFiliere(int id){
        QEtudiant qEtudiant=QEtudiant.etudiant;
        return new JPAQuery<Etudiant>(em)
                .select(qEtudiant)
                .from(qEtudiant)
                .where(qEtudiant.filiere.id.eq(id))
                .fetch();
    }

}


