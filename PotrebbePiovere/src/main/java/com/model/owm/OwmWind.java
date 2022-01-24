package com.model.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe da OWM
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwmWind {
	  private double speed;
	  private int deg;
	  private double gust;

	 // Getter Methods 

	  public double getSpeed() {
	    return speed;
	  }

	  public int getDeg() {
	    return deg;
	  }
	  
	  public double getGust() {
		    return gust;
	  }

	 // Setter Methods 

	  public void setSpeed( double speed ) {
	    this.speed = speed;
	  }

	  public void setDeg( int deg ) {
	    this.deg = deg;
	  }
	  
	  public void setGust( double gust ) {
		    this.gust = gust;
	  }
	}
