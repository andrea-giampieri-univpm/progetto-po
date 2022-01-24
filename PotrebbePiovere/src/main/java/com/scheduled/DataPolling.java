package com.scheduled;

import java.util.ArrayList;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.model.CurrentWeather;
import com.utils.Config;

/**
 * Gestione delle attività schedulate di salvataggio dati con spring
 * @author Andrea Giampieri
 *
 */
@Component
public class DataPolling {
	
	@Scheduled(fixedRate = 3600000) //inserire da config?
	@Async
	public void getCurrentWeather() {
		ArrayList<Long> cities = Config.getCities(); //lista delle citta da interrogare
		RestTemplate restTemplate = new RestTemplate(); //oggetto mapper di spring
		for(Long cityId: cities) {
			try { 
				//costruisco oggetto da resttemplate
				CurrentWeather cw = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?id="+cityId+"&appid="+Config.getConf("owm_apikey")+"&units=metric&lang=it", CurrentWeather.class);
				System.out.println(cw); //output per diagnostica
				cw.appendToFile(); //salvo il file
			} catch (RestClientException e) {
				System.out.println(e);
			}
		}
	}
}
