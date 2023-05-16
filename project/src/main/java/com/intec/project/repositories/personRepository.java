package com.intec.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intec.project.entities.person;

public interface personRepository extends JpaRepository<person, Long> {

    person save(person person);
   
}