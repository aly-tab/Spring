package com.wp.ninjagoldgame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldGameController {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
        	session.setAttribute("count", 0);
        } else {
        	ArrayList<String> notifications = new ArrayList<String>();
        	String notify = (String) session.getAttribute("notify");
        	notifications.add(notify);
        	model.addAttribute("controllerNoifications", notifications);
        }
		

		return "index.jsp";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@RequestParam(value="num1") int num1, @RequestParam(value="num2") int num2, @RequestParam(value="location") String location,HttpSession session) {
		
	    Date date = new Date();
		SimpleDateFormat dayNumF = new SimpleDateFormat("dd");
		String dayNum = dayNumF.format(date);
		SimpleDateFormat monthF = new SimpleDateFormat("MMM");
		String month = monthF.format(date);
		SimpleDateFormat yearF = new SimpleDateFormat("YYYY");
		String year = yearF.format(date);
		SimpleDateFormat timeF = new SimpleDateFormat("HH:mm a");
		String time = timeF.format(date);
		
		session.setAttribute("num1", num1);
		int first = (int) session.getAttribute("num1");
		session.setAttribute("num2", num2);
		int second = (int) session.getAttribute("num2");
		session.setAttribute("location", location);
		String loc = (String) session.getAttribute("location");
		
		if (second == 50) {
			int randInt = (int) (first + (Math.random() * (second - first)));
			int currentCount = (int) session.getAttribute("count");
			int random = (int) (Math.random() * 2) + 1;
			if (random == 1) {
		        currentCount += randInt;
		        session.setAttribute("count", currentCount);
		        String notify = "You entered " + loc + " and earned " + randInt + " gold. (" + month + " " + dayNum + " " + year + " " + time + ")";
		        session.setAttribute("notify", notify);
			} else {
		        currentCount -= randInt;
		        session.setAttribute("count", currentCount);
		        String notify = "You entered " + loc + " and lost " + randInt + " gold. (" + month + " " + dayNum + " " + year + " " + time + ")";
		        session.setAttribute("notify", notify);
			}
		} else {
			int randInt = (int) (first + (Math.random() * (second - first)));
			int currentCount = (int) session.getAttribute("count");
			currentCount += randInt;
			session.setAttribute("count", currentCount);
	        String notify = "You entered " + loc + " and earned " + randInt + " gold. (" + month + " " + dayNum + " " + year + " " + time + ")";
	        session.setAttribute("notify", notify);
		}
		 
		return "redirect:/";
	}

}
