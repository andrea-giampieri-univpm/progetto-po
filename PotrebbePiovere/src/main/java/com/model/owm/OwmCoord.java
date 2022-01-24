package com.model.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe da OWM
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class OwmCoord {
	  private double lon;
	  private double lat;


	 // Getter Methods 

	  public double getLon() {
	    return lon;
	  }

	  public double getLat() {
	    return lat;
	  }

	 // Setter Methods 

	  public void setLon( double lon ) {
	    this.lon = lon;
	  }

	  public void setLat( double lat ) {
	    this.lat = lat;
	  }
	}
