package com.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.model.City;

/**
 * Controller per le statistiche, vedere istruzioni su github
 * @author Andrea Giampieri
 *
 */
@RestController
public class StatsController {

	@GetMapping(value="/getstats",produces = "application/json;")
	public String getStats(@RequestParam(value = "cityid") long cityId) {
		try {
			City city = new City(cityId);
			return city.getStatJson();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(),e);
		}
		
	}
	
	@GetMapping(value="/getstatsfiltered",produces = "application/json;")
	public String getStatsFiltered(@RequestParam(value = "cityid") long cityId,@RequestParam(value = "from") long from,@RequestParam(value = "to") long to) {
		try {
			City city = new City(cityId,from,to);
			return city.getStatJson();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(),e);
		}
	}
	
	@PostMapping("/getstatsfilteredmulti") //statistica con array di date da fare in post
	public String getStatsFilterfd(@RequestBody String body) {
		return "Greetings from Spring Boot!";
	}
	
	
}
