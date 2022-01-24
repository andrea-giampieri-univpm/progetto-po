package com.model.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe da OWM
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwmWeather {
	private int id;
	private String main;
	private String description;
	private String icon;

	// Getter Methods 

	public int getId() {
		return id;
	}

	public String getMain() {
		return main;
	}

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

	// Setter Methods 

	public void setId( int id ) {
		this.id = id;
	}

	public void setMain( String main ) {
		this.main = main;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	public void setIcon( String icon ) {
		this.icon = icon;
	}
}
