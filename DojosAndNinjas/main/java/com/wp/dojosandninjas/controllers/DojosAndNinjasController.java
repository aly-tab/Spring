package com.wp.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wp.dojosandninjas.models.Dojo;
import com.wp.dojosandninjas.models.Ninja;
import com.wp.dojosandninjas.services.DojosAndNinjasService;

@Controller
public class DojosAndNinjasController {
	private final DojosAndNinjasService dojosAndNinjasService;
	
	public DojosAndNinjasController(DojosAndNinjasService dojosAndNinjasService) {
		this.dojosAndNinjasService = dojosAndNinjasService;
	}
	
	@RequestMapping("/dojos/new")
	public String dojos(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojosandninjas/dojo.jsp";
	}
	
	@RequestMapping(value="/dojos",  method=RequestMethod.POST)
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
	       return "/dojos/new";
	    } else {
	        dojosAndNinjasService.createDojo(dojo);
	       return "redirect:/dojos/new";
	    }
	}
	
	@RequestMapping("/ninjas/new")
	public String ninjas(@ModelAttribute("dojo") Dojo dojo, @ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> dojos = dojosAndNinjasService.allDojos();
        model.addAttribute("dojos", dojos);
		return "/dojosandninjas/ninja.jsp";
	}
	
	@RequestMapping(value="/ninjas",  method=RequestMethod.POST)
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
		       return "/ninjas/new";
		    } else {
		        dojosAndNinjasService.createNinja(ninja);
		       return "redirect:/ninjas/new";
		    }
	}
	
	@RequestMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojosAndNinjasService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "/dojosandninjas/show.jsp";
		
	}
}
