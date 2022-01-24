package com.model.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe da OWM
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwmSys {
	  private int type;
	  private int id;
	  private double message;
	  private String country;
	  private long sunrise;
	  private long sunset;


	 // Getter Methods 

	  public int getType() {
	    return type;
	  }

	  public int getId() {
	    return id;
	  }

	  public double getMessage() {
	    return message;
	  }

	  public String getCountry() {
	    return country;
	  }

	  public long getSunrise() {
	    return sunrise;
	  }

	  public long getSunset() {
	    return sunset;
	  }

	 // Setter Methods 

	  public void setType( int type ) {
	    this.type = type;
	  }

	  public void setId( int id ) {
	    this.id = id;
	  }

	  public void setMessage( double message ) {
	    this.message = message;
	  }

	  public void setCountry( String country ) {
	    this.country = country;
	  }

	  public void setSunrise( long sunrise ) {
	    this.sunrise = sunrise;
	  }

	  public void setSunset( long sunset ) {
	    this.sunset = sunset;
	  }
	}

