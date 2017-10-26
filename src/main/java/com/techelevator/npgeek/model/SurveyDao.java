package com.techelevator.npgeek.model;

import java.util.List;
import java.util.Map;

public interface SurveyDao {

	public List<Survey> getAllSurveys();
	public Survey getSurveyById(int surveyId);
	public void save(Survey survey);
//	public List<Survey> getTopParks();
	public List<Map<String, Integer>> getTopParks();
}
