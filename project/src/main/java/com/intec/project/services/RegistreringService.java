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
import java.time.LocalDate;
import java.util.Objects;


public class RegistreringService {

    RegistreringRepository rr = new RegistreringRepository();
    PersonRepository pr = new PersonRepository();
    LokationRepository lr = new LokationRepository();
    FirmaRepository fr = new FirmaRepository();

    public void createNewRegistrering(WebRequest dataFromForm){
        rr.create(getRegistrering(dataFromForm));
        pr.create(Objects.requireNonNull(getPerson(dataFromForm)));
        lr.create(Objects.requireNonNull(getLokation(dataFromForm)));
        fr.create(Objects.requireNonNull(getFirma(dataFromForm)));
    }

    private registrering getRegistrering(WebRequest dataFromForm) {
        return null;
    }

    private firma getFirma(WebRequest dataFromForm) {
        try {
            String firma_navn = dataFromForm.getParameter("firma_navn");

            if (firma_navn != null) {
                return new firma(firma_navn);
            }

            System.out.println("firma not created");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("firma not created");
        }

        return null;
    }

    private person getPerson(WebRequest dataFromForm) {
        try {
            String fnavn = dataFromForm.getParameter("fnavn");
            String enavn = dataFromForm.getParameter("enavn");
            String kørerkort_nummer = dataFromForm.getParameter("kørerkort_nummer");
            LocalDate fødselsdato = LocalDate.parse(Objects.requireNonNull(dataFromForm.getParameter("fødselsdato")));

            if (fnavn != null && enavn != null && kørerkort_nummer != null && fødselsdato != null) {
                return new person(fnavn, enavn, kørerkort_nummer, fødselsdato);
            }

            System.out.println("person not created");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("person not created");
        }

        return null;
    }

    private lokation getLokation(WebRequest dataFromForm) {
        try {
            String lokation_navn = dataFromForm.getParameter("lokation_navn");

            if (lokation_navn != null) {
                return new lokation(lokation_navn);
            }

            System.out.println("lokation not created");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("lokation not created");
        }

        return null;
    }
}
