package com.intec.project.services;

import com.intec.project.UseCaseController.*;
import com.intec.project.entities.firma;
import com.intec.project.entities.lokation;
import com.intec.project.entities.person;
import com.intec.project.entities.registrering;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


public class UseCaseController {
    RegistreringRepository rr = new RegistreringRepository(); // Oprettelse af RegistreringRepository-objekt
    PersonRepository pr = new PersonRepository(); // Oprettelse af PersonRepository-objekt
    LokationRepository lr = new LokationRepository(); // Oprettelse af LokationRepository-objekt
    FirmaRepository fr = new FirmaRepository(); // Oprettelse af FirmaRepository-objekt

    GDPR gdpr = new GDPR(); // Oprettelse af GDPR-objekt

    public void createNewRegistrering(WebRequest dataFromForm){
        // Opretter en ny registrering, person, lokation og firma ved hjælp af data fra formularen
        rr.create(getRegistrering(dataFromForm));
        pr.create(Objects.requireNonNull(getPerson(dataFromForm)));
        lr.create(Objects.requireNonNull(getLokation(dataFromForm)));
        fr.create(Objects.requireNonNull(getFirma(dataFromForm)));
    }

    public void sletPersonData(WebRequest dataFromForm){
        gdpr.delete(LocalDateTime.now().minusYears(5)); // Sletter persondata, der er ældre end 5 år
    }

    private registrering getRegistrering(WebRequest dataFromForm) {
        return null; // Returnerer null (ikke implementeret)
    }

    private firma getFirma(WebRequest dataFromForm) {
        try {
            String firma_navn = dataFromForm.getParameter("firma_navn");

            if (firma_navn != null) {
                return new firma(firma_navn); // Opretter et nyt firmaobjekt med firma_navn
            }

            System.out.println("firma not created"); // Udskriver en fejlmeddelelse, hvis firmaet ikke kunne oprettes
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("firma not created"); // Udskriver en fejlmeddelelse ved en exception
        }

        return null; // Returnerer null, hvis firmaet ikke kunne oprettes
    }

    private person getPerson(WebRequest dataFromForm) {
        try {
            String fnavn = dataFromForm.getParameter("fnavn");
            String enavn = dataFromForm.getParameter("enavn");
            String kørerkort_nummer = dataFromForm.getParameter("kørerkort_nummer");
            LocalDate fødselsdato = LocalDate.parse(Objects.requireNonNull(dataFromForm.getParameter("fødselsdato")));

            if (fnavn != null && enavn != null && kørerkort_nummer != null && fødselsdato != null) {
                return new person(fnavn, enavn, kørerkort_nummer, fødselsdato); // Opretter et nyt personobjekt med de angivne parametre
            }

            System.out.println("person not created"); // Udskriver en fejlmeddelelse, hvis personen ikke kunne oprettes
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("person not created"); // Udskriver en fejlmeddelelse ved en exception
        }

        return null; // Returnerer null, hvis personen ikke kunne oprettes
    }

    private lokation getLokation(WebRequest dataFromForm) {
        try {
            String lokation_navn = dataFromForm.getParameter("lokation_navn");

            if (lokation_navn != null) {
                return new lokation(lokation_navn); // Opretter et nyt lokationobjekt med lokation_navn
            }

            System.out.println("lokation not created"); // Udskriver en fejlmeddelelse, hvis lokationen ikke kunne oprettes
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("lokation not created"); // Udskriver en fejlmeddelelse ved en exception
        }

        return null; // Returnerer null, hvis lokationen ikke kunne oprettes
    }
}
