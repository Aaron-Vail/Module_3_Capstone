package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDao;
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
									ModelMap modelHolder) {
		
		Park park = parkDao.getParkByCode(parkCode);
		modelHolder.addAttribute("park", parkDao.getParkByCode(parkCode));
		modelHolder.addAttribute("weatherList", weatherDao.getWeatherByParkCode(parkCode));	
				for(Park p : parkDao.getAllParks()){
					if(p.getParkCode().equals(parkCode)){
						modelHolder.put("park", p);
					}
				}
		return "view";	
	}
	
	@RequestMapping(path="/parkForm", method=RequestMethod.POST) 
	public String getSurveyForm(@RequestParam String parkCode, 
									@RequestParam String email, 
									@RequestParam String state, 
									@RequestParam String activityLevel, 
									HttpSession session) {
		
		if(session.getAttribute("survey") == null) {
			session.setAttribute("survey", new Survey());
		}
		
		Survey survey = (Survey) session.getAttribute("survey");
		
		
		return "redirect:/parkResult";
	}
	
	@RequestMapping(path="/parkResult", method=RequestMethod.GET)
	public String getSurveyResult(ModelMap modelHandler) {
		
		List<Survey> allSurveyResults = surveyDao.getAllSurveys();
		modelHandler.put("survey", allSurveyResults);
		
		return "parkResult";
	}
	
	@RequestMapping(path={"/favoriteparks"}, method=RequestMethod.GET)
	public String showFavoriteParks(Model modelHolder) {
		
		modelHolder.addAttribute("topParksList", surveyDao.getTopParks());
		return "favoriteParks";
	}
}
