package com.intec.project.UIcontroller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.intec.project.entities.person;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
@RestController
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

    @RequestMapping(value="/save", method=RequestMethod.POST)    
    public ModelAndView save(@ModelAttribute person person) 
    {    
    ModelAndView modelAndView = new ModelAndView();    
    modelAndView.setViewName("person");        
    modelAndView.addObject("person", person);      
    return modelAndView;    
}    

    
}
