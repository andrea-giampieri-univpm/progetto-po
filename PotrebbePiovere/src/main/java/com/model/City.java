package com.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.exception.CurrentWeatherException;
import com.model.stats.FilteredWeatherStat;
import com.model.stats.Stats;
import com.model.stats.WeatherStats;
import com.utils.Config;

/**
 * Classe contenitore dei dati di una città (statistiche e storico)
 * @author Andrea Giampieri
 *
 */
public class City {

	private long id;
	private ArrayList<CurrentWeather> historicWeather;
	private Stats pressStats;
	
	/**
	 * Costruttore
	 * @param id id città
	 * @throws CurrentWeatherException eccezione in caso di id non valido o dati storici non presenti
	 */
	public City(long id) throws CurrentWeatherException{
		this.id=id;
		this.historicWeather = new ArrayList<CurrentWeather>();
		this.dataLoad();
		pressStats = new WeatherStats(historicWeather,id);
	}
	
	/**
	 * Costruttore con dati filtrati
	 * @param id id città
	 * @param from data di inizio filtro in formato unix timestamp
	 * @param to data di fine filtro in formato unix timestamp
	 * @throws CurrentWeatherException eccezione in caso di id non valido o dati storici non presenti
	 */
	public City(long id, long from, long to) throws CurrentWeatherException{
		this.id=id;
		this.historicWeather = new ArrayList<CurrentWeather>();
		this.dataLoad();
		pressStats = new FilteredWeatherStat(historicWeather,id,from,to);
	}
	
	/**
	 * Caricamento dei dati storici in memoria
	 * @throws CurrentWeatherException in caso di file mancante o non leggibile
	 */
	private void dataLoad() throws CurrentWeatherException{ //aggiungere filtro?
		try {
			FileReader fr = new FileReader(Config.getConf("data_path")+"data_"+this.id+".json");
			BufferedReader br = new BufferedReader(fr);
			String line;
			do {//leggo il file dei dati riga per riga, ogni riga è un oggetto currentweather
				line=br.readLine();
				try {//gestisco separatamente una riga errata nel file
					historicWeather.add(new CurrentWeather(line));
				} catch (Exception e) {
					System.out.println("riga ignorata in parsing dati storici:\n"+line);
				}
			} while(line!=null);
			br.close();
        } catch (FileNotFoundException e) {
        	throw new CurrentWeatherException("Dati storici citta "+this.id+" non esistente");
        }catch (Exception e) {
        	throw new CurrentWeatherException("errore non specificato storico citta");
        }
	}
	
	/**
	 * Converte l'oggetto in una stringa json
	 * @return String con i dati completi
	 */
	public String getStatJson() {
		return pressStats.toJsonString();
	}
}
