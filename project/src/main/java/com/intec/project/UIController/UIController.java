package com.intec.project.UIController;

import com.intec.project.UseCaseController.FirmaRepository;
import com.intec.project.UseCaseController.LokationRepository;
import com.intec.project.UseCaseController.PersonRepository;
import com.intec.project.UseCaseController.RegistreringRepository;
import com.intec.project.services.RegistreringService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


@Controller
public class UIController {
    private RegistreringService rs = new RegistreringService();
    private RegistreringRepository rr = new RegistreringRepository();
    private PersonRepository pr = new PersonRepository();
    private FirmaRepository fr = new FirmaRepository();
    private LokationRepository lr = new LokationRepository();

    @RequestMapping("/")
	public String index() {return "index";}

    @GetMapping("/dansk")
	public String dansk() {return "dansk";}

    @GetMapping("/engelsk")
	public String engelsk() {
		return "engelsk";
	}

    @GetMapping("/omos")
    public String omos() {
        return "omos";
    }

    @GetMapping("/aboutus")
    public String aboutus() {
        return "aboutus";
    }

    @GetMapping("/kontaktos")
    public String kontaktos() {
        return "kontaktos";
    }

    @GetMapping("/contactus")
    public String contactus() {
        return "contactus";
    }

    @GetMapping("/privatpolitik")
    public String privatpolitik() {
        return "privatpolitik";
    }

    @GetMapping("/privacypolicy") 
        public String privacypolicy() {
            return "privacypolicy";
        }
    

    @GetMapping("/formularDansk")
    public String formularDansk(){return "formularDansk";}

    @GetMapping("/formularEngelsk")
    public String formularEngelsk(){
        return "formularEngelsk";
    }

    @PostMapping("/create-new-registrering")
    public String createNewRegistrering(WebRequest dataFromForm){
        rs.createNewRegistrering(dataFromForm);
        pr.getAll();
        fr.getAll();
        lr.getAll();
        rr.getAll();
        return "registreretDansk";
    }
    @GetMapping("/registreretDansk")
    public String registreretDansk(){return "registreretDansk";}


    @GetMapping("/error")
    public String error(Model model) {
        model.addAttribute("errorMessage", "Oops! Something went wrong. \n Please contact the system administrator.");
        return "error";
    }


}
