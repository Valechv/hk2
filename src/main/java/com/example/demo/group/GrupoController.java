package com.example.demo.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoRepository grupoRepository;

    @GetMapping
    public ResponseEntity<List<Grupo>> getGrupos() {
        List<Grupo> grupos = grupoRepository.findAll();
        return new ResponseEntity<>(grupos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> getGrupoById(@PathVariable Long id) {
        Optional<Grupo> grupo = grupoRepository.findById(id);
        return grupo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<List<Grupo>> getGruposByPersonId(@PathVariable Long id) {
        List<Grupo> grupos = grupoRepository.findByPersons_Id(id);
        return new ResponseEntity<>(grupos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createGrupo(@RequestBody Grupo grupo) {
        grupoRepository.save(grupo);
        return ResponseEntity.status(201).body("Created");
    }
}
