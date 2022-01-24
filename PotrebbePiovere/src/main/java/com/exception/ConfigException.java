package com.exception;

/**
 * Classe per errori da classe Config
 * @author Andrea Giampieri
 *
 */
public class ConfigException  extends Exception{

	static final long serialVersionUID=0; //implementazione consigliata (warning) da classe exception

	/**
	 * eccezione personalizzata con parametro, passa il parametro in output.
	 * @param string testo aggiuntivo da inserire nell'errore
	 */
	public ConfigException(String string){
		super("Errore configurazione:\n"+string);
	}
	
}
