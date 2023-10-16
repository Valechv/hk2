package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> persons = personRepository.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<List<Person>> getPersonsByGroupId(@PathVariable Long id) {
        List<Person> persons = personRepository.findByGrupos_Id(id);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody Person person) {
        personRepository.save(person);
        return ResponseEntity.status(201).body("Created");
    }
}
