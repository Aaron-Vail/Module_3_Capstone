package com.techelevator.npgeek.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDao;
import com.techelevator.npgeek.model.Weather;
import com.techelevator.npgeek.model.WeatherDao;

@Controller
public class ParkController {

	@Autowired
	ParkDao parkDao;
	
	@Autowired
	WeatherDao weatherDao;
	
	@Autowired
	SurveyDao surveyDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showParksPage (ModelMap modelHandler) {
		
		List<Park> parks = parkDao.getAllParks();
		modelHandler.put("parks", parks);
		
		return "park";
	}
	
	@RequestMapping(path="/view/{parkCode}", method=RequestMethod.GET)
	public String showParkDetail(@PathVariable String parkCode,
									ModelMap modelHolder,
									HttpSession session) {
		
		Park park = parkDao.getParkByCode(parkCode);
		modelHolder.addAttribute("park", park);
		modelHolder.addAttribute("weatherList", weatherDao.getWeatherByParkCode(parkCode));	
				for(Park p : parkDao.getAllParks()){
					if(p.getParkCode().equals(parkCode)){
						modelHolder.put("park", p);
					}
				}
		
		List<Weather> forecast = weatherDao.getWeatherByParkCode(parkCode);
		
		modelHolder.put("weather", forecast);
		
		return "view";	
	}
	
	@RequestMapping(path="/parkForm", method=RequestMethod.GET)
	public String getSurveyForm(ModelMap modelHolder) {
		
		List<Park> parks = parkDao.getAllParks();
 		Park park = new Park();
		Survey survey = new Survey();
		
		modelHolder.put("parks", parks);
		modelHolder.put("park", park);
		modelHolder.put("survey", survey);
		
		return "parkForm";
	}
	
	@RequestMapping(path="/parkForm", method=RequestMethod.POST) 
	public String postSurveyForm(@RequestParam String parkCode, 
									@RequestParam String email, 
									@RequestParam String state, 
									@RequestParam String activityLevel, 
									HttpSession session) {
		
		if(session.getAttribute("survey") == null) {
			session.setAttribute("survey", new Survey());
		}
		
		Survey survey = (Survey) session.getAttribute("survey");
		
		
		return "redirect:/parkFormResult";
	}
	
	@RequestMapping(path="/parkFormResult", method=RequestMethod.GET)
	public String getSurveyResult(@PathVariable String parkCode, 
									ModelMap modelHandler) {
		
//		List<Survey> surveys = surveyDao.getTopParks(surveyId);
		Park park = parkDao.getParkByCode(parkCode);
		List<Map<String, Integer>> surveys = surveyDao.getTopParks();
//		
		modelHandler.put("park", park);
		modelHandler.put("surveys", surveys);
	
		
		return "parkFormResult";
	}
}
