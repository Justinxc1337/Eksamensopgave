package com.intec.project.UIcontroller;
import org.springframework.stereotype.Controller;
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
		return "dansk";
	}

    @GetMapping("/engesk")
	public String engelsk() {
		return "";
	}

    @RequestMapping(value="/save", method=RequestMethod.POST)    
    public ModelAndView save(@ModelAttribute person person) 
    {    
    ModelAndView modelAndView = new ModelAndView();    
    modelAndView.setViewName("person");        
    modelAndView.addObject("person", person);      
    return modelAndView;    
}    

    @GetMapping("fejl")
    public String fejl() {
        return "indsæt fejl kode java application here:)";
    }

    
}
