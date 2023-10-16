package com.example.demo.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByGrupos_Id(Long grupoId);

}
