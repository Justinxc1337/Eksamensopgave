package com.intec.project.services;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import org.springframework.web.context.request.WebRequest;

import com.intec.project.UseCaseController.UseCaseController;
import com.intec.project.UseCaseController.UseCaseController.opretPerson;
import com.intec.project.entities.person;
import org.springframework.web.context.request.WebRequest;
import com.intec.project.UseCaseController.UseCaseController;
import com.intec.project.entities.person;

public class PersonService{

    private UseCaseController op = new UseCaseController();

    public void createNewPerson(WebRequest dataFromForm) {
        person newPerson = getPerson(dataFromForm);
        if (newPerson != null) {
            op.create(newPerson);
        }
    }
    

    private person getPerson(WebRequest dataFromForm){
        try{
            String fnavn = dataFromForm.getParameter("fnavn");
            String enavn = dataFromForm.getParameter("enavn");
            String kørerkort_nummer = dataFromForm.getParameter("kørerkort_nummer");
            LocalDateTime fødselsdato = LocalDateTime.parse(dataFromForm.getParameter("fødselsdato"));
            
            if(dataFromForm.getParameter("person_id") != null){
                int person_id = Integer.parseInt(dataFromForm.getParameter("person_id"));
                person currentPerson = new person(person_id, fnavn, enavn, kørerkort_nummer, fødselsdato);
                return currentPerson;
            }
            person currentPerson = new person(fnavn, enavn, kørerkort_nummer, fødselsdato);
            return currentPerson;

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("person not created");
        }

        return null;
    }
}