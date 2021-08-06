package com.wp.routespractice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
    @RequestMapping(value="/{location}", method=RequestMethod.GET)
    public String location(@PathVariable("location") String location){
    	if (location.equals("dojo")) {
    		return "The dojo is awesome!";
    	} else if (location.equals("burbank-dojo")) {
    		return "Burbank Dojo is located Southern California.";
    	} else if (location.equals("san-jose")) {
    		return "SJ dojo is the headquarters.";
    	} else {
    		return "error";
    	}
    }

}
