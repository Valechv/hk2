package com.example.demo.group;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    List<Grupo> findByPersons_Id(Long personId);

}
