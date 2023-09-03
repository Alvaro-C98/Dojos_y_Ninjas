package com.mvc.dojoninjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.dojoninjas.models.Dojos;
import com.mvc.dojoninjas.services.ApiService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	private final ApiService apiService;
	public DojoController(ApiService service) {
		this.apiService=service;
	}
	
	@GetMapping("/")
	public String home() {
		return"redirect:/dojos";
	}
	
    @GetMapping("/dojos")
    public String indexDojos(Model model) {
        List<Dojos> dojos = apiService.allDojos();
        model.addAttribute("dojos", dojos);
        return "/dojos/index.jsp";
    }
    
    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojos dojo) {
        return "/dojos/newDojo.jsp";
    }
    
    @PostMapping("/dojos/new")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojos dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "/dojos/newDojo.jsp";
        }else {
            apiService.createDojo(dojo);
            return "redirect:/";
        }
    }
    
}
