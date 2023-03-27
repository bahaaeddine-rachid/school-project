package com.example.demo.Security.ConfigModels;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private int id;

    private String nomRole;

    private String description;

    @ManyToMany(mappedBy = "roles")
    private List<User> userlist;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_privilege",
            joinColumns = @JoinColumn(name="role_id"),
            inverseJoinColumns = @JoinColumn(name="privilege_id"))
    private List<Privilege> privileges;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nomRole='" + nomRole + '\'' +
                ", description='" + description + '\'' +
                ", privileges=" + privileges +
                '}';
    }
}
