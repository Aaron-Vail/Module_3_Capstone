package com.techelevator.npgeek.model;

import java.util.List;

public interface SurveyDao {

	public List<Survey> getAllSurveys();
	public Survey getSurveyById(int surveyId);
	public void save(Survey survey);
	public Object getTopParks();
}
