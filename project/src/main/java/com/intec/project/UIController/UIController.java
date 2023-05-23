package com.intec.project.UIcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.intec.project.entities.person;

@Controller

public class UIcontroller {

    @RequestMapping("/")
	public String index() {
		return "index";
	}

    @GetMapping("/dansk")
	public String dansk() {
		return "redirect:/DA";
	}

    @GetMapping("/engelsk")
	public String engelsk() {
		return "redirect:/EN";
	}

    @GetMapping("/formularDansk")
    public String formularDansk(){
        return "redirect:/formularDA";
    }

    @GetMapping("/formularEngelsk")
    public String formularEngelsk(){
        return "redirect:/formularEN";
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)    
    public ModelAndView save(@ModelAttribute person person) 
    {    
    ModelAndView modelAndView = new ModelAndView();    
    modelAndView.setViewName("person");
    modelAndView.addObject("person", person);      
    return modelAndView;    
}

    @GetMapping("/errorEN")
    public String error(Model model) {
        model.addAttribute("errorMessage", "Oops! Something went wrong.");
        return "errorEN";
    }

    @GetMapping("/errorDA")
    public String error(Model model) {
        model.addAttribute("Fejlbesked", "Oops! Noget gik galt.");
        return "errorDA";
    }


}
