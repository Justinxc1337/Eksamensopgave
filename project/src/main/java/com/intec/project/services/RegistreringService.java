package com.intec.project.services;

import com.intec.project.UseCaseController.FirmaRepository;
import com.intec.project.UseCaseController.LokationRepository;
import com.intec.project.UseCaseController.PersonRepository;
import com.intec.project.UseCaseController.RegistreringRepository;
import com.intec.project.entities.firma;
import com.intec.project.entities.lokation;
import com.intec.project.entities.person;
import com.intec.project.entities.registrering;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

public class RegistreringService {

    RegistreringRepository rr = new RegistreringRepository();
    PersonRepository pr = new PersonRepository();
    LokationRepository lr = new LokationRepository();
    FirmaRepository fr = new FirmaRepository();

    public void createNewRegistrering(WebRequest dataFromForm){
        rr.create(getRegistrering(dataFromForm));
        pr.create(getPerson(dataFromForm));
        lr.create(getLokation(dataFromForm));
        fr.create(getFirma(dataFromForm));
    }

    private registrering getRegistrering(WebRequest dataFromForm){
        try{
            int firma_id = Integer.parseInt(dataFromForm.getParameter("firma_id"));
            int person_id = Integer.parseInt(dataFromForm.getParameter("person_id"));
            int lokation_id = Integer.parseInt(dataFromForm.getParameter("lokation_id"));
            LocalDateTime indtjekningstidspunkt = LocalDateTime.parse(dataFromForm.getParameter("indtjekningstidspunkt"));

            if(dataFromForm.getParameter("registrering_id") != null){
                int registrering_id = Integer.parseInt(dataFromForm.getParameter("registrering_id"));
                registrering currentRegistrering = new registrering(registrering_id, firma_id, person_id, lokation_id, indtjekningstidspunkt);
                return currentRegistrering;
            }
            registrering currentRegistrering = new registrering(firma_id, person_id, lokation_id, indtjekningstidspunkt);
            return currentRegistrering;

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("registrering not created");
        }

        return null;
    }

    private firma getFirma(WebRequest dataFromForm){
        try{
            String firma_navn = dataFromForm.getParameter("firma_navn");

            if(dataFromForm.getParameter("firma_id") != null){
                int firma_id = Integer.parseInt(dataFromForm.getParameter("firma_id"));
                firma currentFirma = new firma(firma_id, firma_navn);
                return currentFirma;
            }
            firma currentFirma = new firma(firma_navn);
            return currentFirma;

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("firma not created");
        }

        return null;
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

    private lokation getLokation(WebRequest dataFromForm){
        try{
            String lokation_navn = dataFromForm.getParameter("lokation_navn");

            if(dataFromForm.getParameter("lokation_id") != null){
                int lokation_id = Integer.parseInt(dataFromForm.getParameter("lokation_id"));
                lokation currentLokation = new lokation(lokation_id, lokation_navn);
                return currentLokation;
            }
            lokation currentLokation = new lokation(lokation_navn);
            return currentLokation;

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("lokation not created");
        }

        return null;
    }
}
