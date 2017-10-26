package com.techelevator.npgeek.model;

public class Park {
	
		private String parkCode;
		private String parkName;
		private String state;
		private int acreage;
		private int elevation;
		private double trailMiles;
		private int numOfCamps;
		private String climate; 
		private int yearFounded;
		private int annualVisitors;
		private String inspirationalQuote;
		private String inspirationalQuoteSource;
		private String parkDescription;
		private int entryFee;
		private int numberOfSpecies;
		
		public String getParkCode() {
			return parkCode.toLowerCase();
		}
		public void setParkCode(String parkCode) {
			this.parkCode = parkCode;
		}
		public String getParkName() {
			return parkName;
		}
		public void setParkName(String parkName) {
			this.parkName = parkName;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public int getAcreage() {
			return acreage;
		}
		public void setAcreage(int acreage) {
			this.acreage = acreage;
		}
		public int getElevation() {
			return elevation;
		}
		public void setElevation(int elevation) {
			this.elevation = elevation;
		}
		public double getTrailMiles() {
			return trailMiles;
		}
		public void setTrailMiles(double trailMiles) {
			this.trailMiles = trailMiles;
		}
		public int getNumOfCamps() {
			return numOfCamps;
		}
		public void setNumOfCamps(int numOfCamps) {
			this.numOfCamps = numOfCamps;
		}
		public String getClimate() {
			return climate;
		}
		public void setClimate(String climate) {
			this.climate = climate;
		}
		public int getYearFounded() {
			return yearFounded;
		}
		public void setYearFounded(int yearFounded) {
			this.yearFounded = yearFounded;
		}
		public int getAnnualVisitors() {
			return annualVisitors;
		}
		public void setAnnualVisitors(int annualVisitors) {
			this.annualVisitors = annualVisitors;
		}
		public String getInspirationalQuote() {
			return inspirationalQuote;
		}
		public void setInspirationalQuote(String inspirationalQuote) {
			this.inspirationalQuote = inspirationalQuote;
		}
		public String getInspirationalQuoteSource() {
			return inspirationalQuoteSource;
		}
		public void setInspirationalQuoteSource(String inspirationalQuoteSource) {
			this.inspirationalQuoteSource = inspirationalQuoteSource;
		}
		public String getParkDescription() {
			return parkDescription;
		}
		public void setParkDescription(String parkDescription) {
			this.parkDescription = parkDescription;
		}
		public int getEntryFee() {
			return entryFee;
		}
		public void setEntryFee(int entryFee) {
			this.entryFee = entryFee;
		}
		public int getNumberOfSpecies() {
			return numberOfSpecies;
		}
		public void setNumberOfSpecies(int numberOfSpecies) {
			this.numberOfSpecies = numberOfSpecies;
		}		
}
