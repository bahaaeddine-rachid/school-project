package com.example.demo.repository.Impl;

import com.example.demo.models.*;
import com.example.demo.repository.CustomEtudiantRepository;
import com.querydsl.core.types.EntityPath;
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
//    @Override
//    public List<Etudiant> findEtudiantById(int id) {
//        MapSqlParameterSource parameters = new MapSqlParameterSource();
//        parameters.addValue("id", id);
//        log.info("" + id);
//        String sql = "select * from etudiant WHERE etudiant_id=:id";
//        String sql2 = "select * from filiere";
//
//        List<Etudiant> result = new ArrayList<>();
//        try {
//            result = jdbcTemplate.query(
//                    sql,
//                    parameters,
//                    new EtudiantMapper());
//
//        } catch (EmptyResultDataAccessException e) {
//            log.error(e.getLocalizedMessage());
//        }
//        if (result.isEmpty()) {
//            return new ArrayList<>();
//        } else {
//            for (Etudiant et : result) {
//                MapSqlParameterSource parameters2 = new MapSqlParameterSource();
//                parameters2.addValue("filiere_id", et.getFiliere().getId());
//
//                et.setFiliere(
//                        jdbcTemplate.query(sql2, parameters2, new FiliereMapper()).get(0)
//                );
//            }
//            return result;
//        }
//
//    }
    @Override
    public List<Etudiant> findEtudiantbyFiliere(int id){
        QEtudiant qEtudiant=QEtudiant.etudiant;
        return new JPAQuery<Etudiant>(em)
                .select(qEtudiant)
                .from(qEtudiant)
                .where(qEtudiant.filiere.id.eq(id))
                .fetch();
    }

//    @Override
//    public List<Etudiant> findEtudiantbyFiliere(int filiereId) {
//        MapSqlParameterSource parameters = new MapSqlParameterSource();
//        parameters.addValue("filiereId", filiereId);
//
//        String sql = "select * from etudiant WHERE filiere_id=:filiereId";
//        String sql2 = "select * from filiere WHERE filiere_id=:filiereId";
//        List<Etudiant> result = new ArrayList<>();
//        try {
//            result = jdbcTemplate.query(
//                    sql,
//                    parameters,
//                    new EtudiantMapper());
//
//
//        } catch (EmptyResultDataAccessException e) {
//            log.error(e.getLocalizedMessage());
//        }
//        if (result.isEmpty()) {
//            return new ArrayList<>();
//        } else {
//            for(Etudiant tr:result){
//                MapSqlParameterSource parameters2 = new MapSqlParameterSource();
//                parameters2.addValue("filiereId", tr.getFiliere().getId());
//
//                tr.setFiliere(
//                        jdbcTemplate.query(sql2,parameters2,new FiliereMapper()).get(0)
//                );
//            }
//            return result;
//        }
//
//    }

}


