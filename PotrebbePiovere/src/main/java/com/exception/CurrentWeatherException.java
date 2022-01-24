package com.exception;

/**
 * Eccezioni per la classe CurrentWeather
 * @author Andrea Giampieri
 *
 */
public class CurrentWeatherException extends Exception {

	static final long serialVersionUID=0; //implementazione consigliata (warning) da classe exception
		
	/**
	 * eccezione personalizzata
	 */
	public CurrentWeatherException(){
		super("Errore creazione oggetto CurrentWeather");
	}
	
	/**
	 * eccezione personalizzata con parametro, passa il parametro in output.
	 */
	public CurrentWeatherException(String string){
		super("Errore creazione oggetto CurrentWeather: "+string);
	}
	
	
}
