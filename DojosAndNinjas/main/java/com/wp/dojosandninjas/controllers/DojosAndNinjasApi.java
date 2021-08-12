package com.wp.dojosandninjas.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wp.dojosandninjas.models.Dojo;
import com.wp.dojosandninjas.models.Ninja;
import com.wp.dojosandninjas.services.DojosAndNinjasService;

public class DojosAndNinjasApi {
	private final DojosAndNinjasService dojosAndNinjasService;
	public DojosAndNinjasApi(DojosAndNinjasService dojosAndNinjasService) {
		this.dojosAndNinjasService = dojosAndNinjasService;
	}
	
    @RequestMapping(value="/api/dojos", method=RequestMethod.POST)
    public Dojo create(@RequestParam(value="name") String name) {
        Dojo dojo = new Dojo(name);
        return dojosAndNinjasService.createDojo(dojo);
    }
    
    @RequestMapping(value="/api/ninjas", method=RequestMethod.POST)
    public Ninja create(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, @RequestParam(value="age") int age) {
        Ninja ninja = new Ninja(firstName, lastName, age);
        return dojosAndNinjasService.createNinja(ninja);
    }
	
	@RequestMapping("/api/dojos/{id}")
	public Dojo show(@PathVariable("id") Long id) {
		Dojo dojo = dojosAndNinjasService.findDojo(id);
		return dojo;
	}
	
}
