package com.intec.project.services;

import com.intec.project.UseCaseController.FirmaRepository;
import com.intec.project.entities.firma;
import org.springframework.web.context.request.WebRequest;

public class FirmaService {

    FirmaRepository fr = new FirmaRepository();

    public void createNewFirma(WebRequest dataFromForm) {
        fr.create(getFirma(dataFromForm));
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
}
