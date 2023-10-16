package com.example.demo.group;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.util.Set;
import com.example.demo.person.Person;

@Entity
@Table(name = "grupo")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;


    @ManyToMany(mappedBy = "grupos", fetch = FetchType.LAZY)
    private Set<Person> persons;

    public Grupo() {
    }

    public Grupo(Long id, String name, Set<Person> persons) {
        this.id = id;
        this.name = name;
        this.persons = persons;
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

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
