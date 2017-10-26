package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDao implements ParkDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcParkDao(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			allParks.add(mapRowToPark(results));
		}
		return allParks;
	}

	@Override
	public Park getParkByCode(String parkCode) {
		Park park = null;
		String sqlSelectParkByCode = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkByCode, parkCode);
		if(results.next()) {
			park = mapRowToPark(results);
		} 
		return park;
	}
	
	private Park mapRowToPark(SqlRowSet row) {
		Park park = new Park();
		park.setParkCode(row.getString("parkcode"));
		park.setParkName(row.getString("parkname"));
		park.setState(row.getString("state"));
		park.setAcreage(row.getInt("acreage"));
		park.setElevation(row.getInt("elevationinfeet"));
		park.setNumOfCamps(row.getInt("numberofcampsites"));
		park.setClimate(row.getString("climate"));
		park.setYearFounded(row.getInt("yearfounded"));
		park.setAnnualVisitors(row.getInt("annualvisitorcount"));
		park.setInspirationalQuote(row.getString("inspirationalQuote"));
		park.setInspirationalQuoteSource(row.getString("inspirationalQuoteSource"));
		park.setParkDescription(row.getString("parkdescription"));
		park.setEntryFee(row.getInt("entryfee"));
		park.setNumberOfSpecies(row.getInt("numberofanimalspecies"));
		return park;
	}
}
