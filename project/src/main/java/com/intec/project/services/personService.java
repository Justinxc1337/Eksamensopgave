package com.intec.project.services;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intec.project.entities.person;
import com.intec.project.repository.personRepository;

@Service
public class personService{
    @Autowired
    private personRepository personRepository;

    public person registerPerson(String fnavn, String enavn, String kørerkort_nummer,LocalDateTime fødselsdato) {
        person person = new person();
        person.setFnavn(fnavn);
        person.setEnavn(enavn);
        person.setKørerkort_nummer(kørerkort_nummer);
        person.setFødselsdato(fødselsdato);

        return personRepository.save(person);
    }
}
