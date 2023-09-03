package com.mvc.dojoninjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.dojoninjas.models.Dojos;
import com.mvc.dojoninjas.models.Ninjas;
import com.mvc.dojoninjas.services.ApiService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	
	private final ApiService apiService;
	public NinjaController(ApiService service) {
		this.apiService=service;
	}
	
	
    @GetMapping("/ninjas")
    public String indexDojos(Model model) {
        List<Ninjas> ninja = apiService.allNinjas();
        model.addAttribute("ninjas", ninja);
        return "/ninjas/index.jsp";
    }
	
    @GetMapping("/ninjas/new")
    public String ninja(@ModelAttribute("ninja") Ninjas ninja, Model model) {
    	List<Dojos> dojo = apiService.allDojos();
    	model.addAttribute("dojo",dojo);
        return "/ninjas/newNinja.jsp";
    }
    
    @PostMapping("/ninjas/new")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninjas ninjas, 
    		BindingResult result,
    		Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("dojo",apiService.allDojos());
            return "/ninjas/newNinja.jsp";
        }else {
            apiService.createNinja(ninjas);
            return "redirect:/";
        }
    }
}
