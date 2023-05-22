package com.intec.project.UIController;

import com.intec.project.UseCaseController.UseCaseController;
import com.intec.project.entities.registrering;
import com.intec.project.entities.person;
import com.intec.project.entities.lokation;
import com.intec.project.entities.firma;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/templates")
public class UIController {

    @RequestMapping("/")
	public String index() {
		return "index";
	}

    @GetMapping("/dansk")
	public String dansk() {
		return "dansk";
	}

    @GetMapping("/engelsk")
	public String engelsk() {
		return "engelsk";
	}

    @GetMapping("/formularDansk")
    public String formularDansk() {
        return "formularDansk";
    }

    @GetMapping("/formularEngelsk")
    public String formularEngelsk(){
        return "formularEngelsk";
    }


    @GetMapping("/error")
    public String error(Model model) {
        model.addAttribute("errorMessage", "Oops! Something went wrong.");
        return "error";
    }


}
