package com.example.demo.repository.Impl;

import com.example.demo.models.*;
import com.example.demo.repository.CustomFiliereMatiereRepository;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Slf4j
public class CustomFiliereMatiereRepositoryImpl implements CustomFiliereMatiereRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<FiliereMatiere> findmatierebyfiliere(int id){
        QFiliereMatiere qFiliereMatiere=QFiliereMatiere.filiereMatiere;
        QFiliere qFiliere=QFiliere.filiere;
        return new JPAQuery<FiliereMatiere>(em)
                .select(qFiliereMatiere)
                .from(qFiliereMatiere)
                .where(qFiliere.id.eq(id))
                .fetch();
    }

    @Override
    public List<FiliereMatiere> findAllNiveau(){
        QFiliereMatiere qFiliereMatiere=QFiliereMatiere.filiereMatiere;
        return new JPAQuery<FiliereMatiere>(em)
                .from(qFiliereMatiere)
                .fetch();
    }

}
