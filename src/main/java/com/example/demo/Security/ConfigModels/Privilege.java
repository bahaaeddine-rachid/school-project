package com.example.demo.Security.ConfigModels;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="privilege")
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="privilege_id")
    private int id;
    private String name;
    private String description;


    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;

}
