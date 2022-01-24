package com.model.stats;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.interfaces.InterfaceStats;
import com.model.CurrentWeather;

/**
 * Classe per la creazione delle statistiche di pressione dei dati meteo
 * @author Andrea Giampieri
 *
 */
public class WeatherStats extends Stats implements InterfaceStats {
	
	private long min_dt=Long.MAX_VALUE;
	private long max_dt;
	private long id;
	
	/**
	 * costruttore vuoto per estensione classe
	 */
	protected WeatherStats(long id) {
		this.id=id;
		
	}
	
	/**
	 * Costruisco l'array dei dati e calcolo le statistiche
	 * @param weatherList array di dati meteo
	 * @param id id città
	 */
	public WeatherStats(ArrayList<CurrentWeather> weatherList, long id) {
		super();
		this.id=id;
		
		for(CurrentWeather weather: weatherList)
		{
			long dt= weather.getDt();
			if(dt<this.min_dt) this.min_dt=dt;
			if(dt>this.max_dt) this.max_dt=dt;
			data.add(weather.getPressure());
		}
		super.calculate();
	}

	public long getMinDt() {
		return this.min_dt;
	}
	
	public long getMaxDt() {
		return this.max_dt;
	}
	
	public void setMaxDt(long max_dt) {
		this.max_dt = max_dt;
	}
	
	public void setMinDt(long min_dt) {
		this.min_dt = min_dt;
	}
	/**
	 * Converte l'oggetto in una stringa json
	 * @return String con i dati completi
	 */
	@SuppressWarnings("unchecked")
	public String toJsonString() {
		JSONObject json = new JSONObject();
		json.put("id", this.id);
		json.put("press_avg", this.getAverage());
		json.put("press_min", this.getMin());
		json.put("press_max", this.getMax());
		json.put("samples", this.getSampleNum());
		json.put("press_variance", this.getVariance());
		json.put("dt_from", this.getMinDt());
		json.put("dt_to", this.getMaxDt());
		return json.toString();
	}
	

}

