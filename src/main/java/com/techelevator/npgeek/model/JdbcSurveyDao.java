package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDao {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	ParkDao parkDao;
	
	@Autowired 
	SurveyDao surveyDao;
	
	@Autowired
	public JdbcSurveyDao(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> allSurveys = new ArrayList<>();
		String sqlSelectAllSurveys = "SELECT * FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while(results.next()) {
			allSurveys.add(mapRowToSurvey(results));
		}
		return allSurveys;
	}

	@Override
	public Survey getSurveyById(int surveyId) {
		Survey survey = null;
		String sqlSelectSurveyById = "SELECT * FROM survey_result WHERE surveyid = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectSurveyById, surveyId);
		if(results.next()) {
			survey = mapRowToSurvey(results);
		} 
		return survey;	
	}
	
	@Override
	public void save(Survey survey) {
		String sqlInsertSurvey = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sqlInsertSurvey, survey.getParkCode(), survey.getEmail(), survey.getState(), survey.getActivityLevel());
	}
	
	private Survey mapRowToSurvey(SqlRowSet row) {
		Survey survey = new Survey();
		survey.setSurveyId(row.getInt("surveyid"));
		survey.setParkCode(row.getString("parkcode"));
		survey.setEmail(row.getString("emailaddress"));
		survey.setState(row.getString("state"));
		survey.setActivityLevel(row.getString("activitylevel"));
		return survey;
	}

	@Override
	public List<SurveyResults> getTopParks() {
		List<SurveyResults> topParks = new ArrayList<>();
		String statement = "SELECT parkcode, COUNT(*) as votes FROM survey_result GROUP BY parkcode HAVING count(*) > 0 ORDER BY count(*) DESC LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(statement);
		while(results.next()) {
			SurveyResults surveyResult = new SurveyResults();
			surveyResult.setParkCode(results.getString("parkcode"));
			surveyResult.setVotes(results.getInt("votes"));
			topParks.add(surveyResult);
		}
		
		return topParks;
	}
}
