package com.wp.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
    @RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String searchQuery) {
        if (searchQuery == null) {
        	return "<html>\n" + "<body>\n" + "<p>" + "Hello Human!" 
        			+ "</p>" + "<p>" + "Welcome to SpringBoot" + "</p>" + "</body>\n" + "</html>";
        } else {
        	return "<html>\n" + "<body>\n" + "<a href='/' style='float: right'>" + "Go Back" +"</a>" + "<p>" + "Hello " + searchQuery
    			+ "!" + "</p>" + "<p>" + "Welcome to SpringBoot" + "</p>" + "</body>\n" + "</html>";
        }
    }   	
}
