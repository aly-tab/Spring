package com.wp.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDateController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
	    SimpleDateFormat dayF = new SimpleDateFormat("EEEE");
		String day = dayF.format(date);
	    SimpleDateFormat dayNumF = new SimpleDateFormat("dd");
		String dayNum = dayNumF.format(date);
	    SimpleDateFormat monthF = new SimpleDateFormat("MMM");
		String month = monthF.format(date);
	    SimpleDateFormat yearF = new SimpleDateFormat("YYYY");
		String year = yearF.format(date);
        model.addAttribute("day", day);        
        model.addAttribute("dayNum", dayNum);
        model.addAttribute("month", month);
        model.addAttribute("year", year);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		SimpleDateFormat timeF = new SimpleDateFormat("HH:mm a");
		String time = timeF.format(date);
        model.addAttribute("time", time);
		return "time.jsp";
	}
	
}
