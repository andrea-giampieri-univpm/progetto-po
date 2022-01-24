package com.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.exception.ConfigException;

/**
 * Classe per gestire la configurazione dell'applicazione.
 * La classe richiede di lanciare il metodo initialize() per leggere il file e rendere disponibile la configurazione
 * Volutamente non implementato un modello dati specifico ma utilizza esclusivamente l'oggetto JSONObject
 * @author Andrea Giampieri
 *
 */
public class Config {

	private static JSONObject conf; //configurazione gestita come keyvalue in un json obj

	/**
	 * Legge il file config.json nella root del progetto 
	 * rende disponibili i vari parametri
	 * se il file è assente/illegibile
	 * @throws ConfigException quando la configurazione è errata/assente/illegibile/senza parametri minimi
	 */
	public static void initialize() throws ConfigException {
		JSONParser jparser = new JSONParser();
		try {
			conf = (JSONObject) jparser.parse(new BufferedReader (new FileReader ("config.json" ))); //parsing diretto del flusso	
		} catch (FileNotFoundException e) {
			throw new ConfigException("ERRORE: file di configurazione non trovato, app termina esecuzione.");
		} catch (IOException e){
			throw new ConfigException("ERRORE: lettura json interrotta.");
		} catch (ParseException e){
			throw new ConfigException("ERRORE: parsing json configurazione fallito.");
		}
		//check dei parametri indispensabili ed output diagnostico
		if(conf.containsKey("owm_apikey"))System.out.println("Using API KEY: "+conf.get("owm_apikey")); else throw new ConfigException("apikey non trovata");
		if(conf.containsKey("data_path")) System.out.println("Using data path: "+conf.get("data_path")); else throw new ConfigException("percorso salvataggio non trovato");
	
	}
	
	/**
	 * Metodo per ottenere un parametro di configurazione specifico
	 * L'oggetto di ritorno deve essere controllato, può essere stringa, long, double, ecc...
	 * @param param Stringa del nome parametro da ottenere
	 * @return il valore del parametro associato come Object o null se non esistente
	 */
	public static Object getConf(String param) {
		if(conf.containsKey(param)) return conf.get(param); else return null;
	}
	
	/**
	 * Metodo per impostare un parametro nuovo o sovrascrivere un parametro esistente
	 * @param param stringa del nome parametro
	 * @param value oggetto contenente il valore associato al parametro
	 */
	@SuppressWarnings("unchecked")
	public static void setConf(String param, Object value)  {
		try {
			conf.put(param, value);
		} catch (UnsupportedOperationException e ) {
			System.out.println(e);
		}
		
	}
	
	/**
	 * Metodo aggiuntivo a setconf che permette di salvare automaticamente su file la configurazione
	 * @param param stringa del nome parametro
	 * @param value oggetto contenente il valore associato al parametro
	 */
	public static void setConfCommit(String param, Object value)  {
		Config.setConf(param, value);
		Config.commit();
	}
	
	/**
	 * metodo per salvare la configurazione in json su file. sovrascrive la vecchia config
	 */
	public static void commit() {
        try (BufferedWriter br = new BufferedWriter(new FileWriter("config.json" ))) {
            br.write(conf.toJSONString());
            br.close();
        } catch (Exception e) {
        	System.out.println("Errore scrittura file configurazione");
        }
	}
	
	/**
	 * metodo diretto per ottenere un array con la lista delle città di cui salvare i dati
	 * da valutare inserimento in eventuale sottoclasse
	 * @return arraylist di long contenente gli id delle città, null se errore o vuoto 
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Long> getCities(){
		try {
			ArrayList<Long> cities = (ArrayList<Long>) conf.get("cities");
			return cities;
		} catch (ClassCastException e) {
			System.out.println("Errore formato dati da json");
			return null;
		}	
	}
	
	/**
	 * metodo diretto per impostare una nuova città
	 * da valutare inserimento in eventuale sottoclasse
	 * @param cityId id città da lista currentweather
	 */
	@SuppressWarnings("unchecked")
	public static void addCity(Long cityId){
		try {
			if (!((JSONArray) conf.get("cities")).contains(cityId))
			//da aggiungere un controllo dell'id dalla lista
				((JSONArray) conf.get("cities")).add(cityId);
		} catch (ClassCastException e) {
			System.out.println("Errore  dati");
		}	
	}
	
	/**
	 * metodo diretto per rimuovere una nuova città
	 * da valutare inserimento in eventuale sottoclasse
	 * @param cityId id città da lista currentweather
	 */
	public static void removeCity(Long cityId){
		try {
			((JSONArray) conf.get("cities")).remove(cityId);
		} catch (ClassCastException e) {
			System.out.println("Errore  dati");
		}	
	}
	
	/**
	 * Converte l'oggetto configurazione in una stringa json
	 * @return String con la configurazione completa
	 */
	public static String toJsonString() {
		return conf.toString();
	}
}
