package com.example.demo.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="niveau")
public class Niveau {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="niveau_id")
    Integer id;
    Integer niveau;


}
