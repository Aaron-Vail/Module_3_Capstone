package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDao;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDao;
import com.techelevator.npgeek.model.SurveyResults;
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
		
		Park park = parkDao.getParkByCode(parkCode.toUpperCase());
		List<Weather> weathers = weatherDao.getWeatherByParkCode(parkCode.toUpperCase());
		
		modelHolder.put("park", park);
		modelHolder.put("weathers", weathers);
		
		if(session.getAttribute("parkCode") == null) {
			session.setAttribute("parkCode", new Weather());
		}
		
		Weather weather = (Weather) session.getAttribute("parkCode");
		weather.getParkCode();
		
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
	
	@RequestMapping(path="/parkFormResult", method=RequestMethod.POST) 
	public String postSurveyForm(@ModelAttribute Survey survey, 
									HttpSession session) {
		
		surveyDao.save(survey);
		
		
		return "redirect:/parkFormResult";
	}
	
	@RequestMapping(path="/parkFormResult", method=RequestMethod.GET)
	public String getSurveyResult(ModelMap modelHandler) {
		
		List<SurveyResults> surveys = surveyDao.getTopParks();
		
		modelHandler.put("surveys", surveys);
	
		
		return "parkFormResult";
	}
}
