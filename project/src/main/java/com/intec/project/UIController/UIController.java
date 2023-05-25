package com.intec.project.UIController;

import com.intec.project.services.RegistreringService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


@Controller
public class UIController {
    private RegistreringService rs = new RegistreringService();


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

    @GetMapping("/kontaktos")
    public String kontaktos() {
        return "kontaktos";
    }

    @GetMapping("/privatpolitik")
    public String privatpolitik() {
        return "privatpolitik";
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
        return "registreretDansk";
    }
    @GetMapping("/registreretDansk")
    public String registreretDansk(){return "registreretDansk";}


    @GetMapping("/error")
    public String error(Model model) {
        model.addAttribute("errorMessage", "Oops! Something went wrong.");
        return "error";
    }


}
