package com.techelevator.npgeek.model;

public class Weather {

		private String parkCode;
		private int day;
		private int lowTemp;
		private int highTemp;
		private String forecast;
		
		public String getParkCode() {
			return parkCode;
		}
		public void setParkCode(String parkCode) {
			this.parkCode = parkCode;
		}
		public int getDay() {
			return day;
		}
		public void setDay(int day) {
			this.day = day;
		}
		public int getLowTemp() {
			return lowTemp;
		}
		public void setLowTemp(int lowTemp) {
			this.lowTemp = lowTemp;
		}
		public int getHighTemp() {
			return highTemp;
		}
		public void setHighTemp(int highTemp) {
			this.highTemp = highTemp;
		}
		public String getForecast() {
			return forecast.toLowerCase();
		}
		public void setForecast(String forecast) {
			this.forecast = forecast;
		}
}
