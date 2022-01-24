package com.interfaces;

/**
 * Interfacce per l'implementazione della statistiche
 * come da progetto
 * @author Andrea Giampieri
 *
 */
public interface InterfaceStats {
	
	/**
	 * 
	 * @return massimo 
	 */
	public double getMax();
	
	/**
	 * 
	 * @return minimo
	 */
	public double getMin();
	
	/**
	 * 
	 * @return media
	 */
	public double getAverage();
	
	/**
	 * 
	 * @return varianza
	 */
	public double getVariance();
	
}
