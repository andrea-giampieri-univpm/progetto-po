package com.model.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe da OWM
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwmMain {
	private double temp;
	private double feels_like;
	private double pressure;
	private double humidity;
	private double temp_min;
	private double temp_max;
	private double sea_level;
	private double grnd_level;

	// Getter Methods 

	public double getTemp() {
		return temp;
	}

	public double getFeels_like() {
		return feels_like;
	}

	public double getPressure() {
		return pressure;
	}

	public double getHumidity() {
		return humidity;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public double getTemp_max() {
		return temp_max;
	}

	public double getSea_level() {
		return sea_level;
	}

	public double getGrnd_level() {
		return grnd_level;
	}

	// Setter Methods 

	public void setTemp( double temp ) {
		this.temp = temp;
	}

	public void setFeels_like( double feels_like ) {
		this.feels_like = feels_like;
	}

	public void setPressure( double pressure ) {
		this.pressure = pressure;
	}

	public void setHumidity( double humidity ) {
		this.humidity = humidity;
	}

	public void setTemp_min( double temp_min ) {
		this.temp_min = temp_min;
	}

	public void setTemp_max( double temp_max ) {
		this.temp_max = temp_max;
	}
	public void setSea_level( double sea_level ) {
		this.sea_level = sea_level;
	}
	public void setGrnd_level( double grnd_level ) {
		this.grnd_level = grnd_level;
	}

}