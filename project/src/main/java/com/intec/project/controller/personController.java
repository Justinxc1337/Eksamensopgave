package com.intec.project.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intec.project.entities.person;
import com.intec.project.services.personService;

public class personController{

    @Autowired
    private personService personService;

    @PostMapping
    public ResponseEntity<person> registerPerson(@RequestParam String fnavn, @RequestParam String enavn, @RequestParam String kørerkort_nummer, @RequestParam LocalDateTime fødselsdato) {
        person person = personService.registerPerson(fnavn, enavn, kørerkort_nummer, fødselsdato);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
