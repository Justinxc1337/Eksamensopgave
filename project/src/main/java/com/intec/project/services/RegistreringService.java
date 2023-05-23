package com.intec.project.services;

import com.intec.project.UseCaseController.RegistreringRepository;
import com.intec.project.entities.registrering;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

public class RegistreringService {

    RegistreringRepository rp = new RegistreringRepository();

    public void createNewRegistrering(WebRequest dataFromForm){
        rp.create(getRegistrering(dataFromForm));
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
}
