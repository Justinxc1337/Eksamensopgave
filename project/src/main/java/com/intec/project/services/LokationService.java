package com.intec.project.services;

import com.intec.project.UseCaseController.LokationRepository;
import com.intec.project.entities.lokation;
import org.springframework.web.context.request.WebRequest;

public class LokationService {

    LokationRepository lr = new LokationRepository();

    public void createNewLokation(WebRequest dataFromForm) {
        lr.create(getLokation(dataFromForm));
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
