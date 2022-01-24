package com.model.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe da OWM
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwmClouds {
	  private int all;


	 // Getter Methods 

	  public int getAll() {
	    return all;
	  }

	 // Setter Methods 

	  public void setAll( int all ) {
	    this.all = all;
	  }
	}