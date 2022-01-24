package com.model.stats;

import java.util.ArrayList;

import com.model.CurrentWeather;

/**
 * Classe per le statistiche filtrate
 * @author Andrea Giampieri
 * 
 */
public class FilteredWeatherStat extends WeatherStats {
		
	/**
	 * Costruisto le statistiche con i dati presenti nel range from-to
	 * @param weatherList array di dati meteo
	 * @param id id città
	 * @param from data inizio in unix timestamp
	 * @param to data fine in unix timestamp
	 */
	public FilteredWeatherStat(ArrayList<CurrentWeather> weatherList, long id, long from, long to) {		
		super(id);
		setMaxDt(to);
		setMinDt(from);
		for(CurrentWeather weather: weatherList)
		{
			long dt = weather.getDt();
			if(dt<=to && dt>=from  )
				data.add(weather.getPressure());
		}
		super.calculate();
	}
	
}
