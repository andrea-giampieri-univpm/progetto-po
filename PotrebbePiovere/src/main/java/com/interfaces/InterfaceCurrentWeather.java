package com.interfaces;


/**
 * Interfacce per l'implementazione della classe
 * CurrentWeather specifica per il progetto
 * 
 * @author Andrea Giampieri
 */
public interface InterfaceCurrentWeather {
	
	/**
	 * aggiunge una riga di json contenente il meteo ad un file di testo
	 */
	public void appendToFile();

	/**
	 * @return valore della pressione come double
	 */
	public double getPressure();
	
	/**
	 * @return valore della temperatura come double
	 */
	public double getTemp();
	
	/**
	 * @return valore della temperatura come long
	 */
	public long getId();
	
	/**
	 * @return valore della temperatura come long
	 */
	public long getDt();
	
}
