package com.example.demo.person;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.util.Set;

import com.example.demo.group.Grupo;

@Entity
@Table(name = "person")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "person_grupo", joinColumns = { @JoinColumn(name = "person_id") }, inverseJoinColumns = {
            @JoinColumn(name = "grupo_id") })
    private Set<Grupo> grupos;

    public Person() {
    }

    public Person(Long id, String name, Set<Grupo> grupos) {
        this.id = id;
        this.name = name;
        this.grupos = grupos;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }
}
