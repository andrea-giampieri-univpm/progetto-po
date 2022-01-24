package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.utils.Config;

/**
 * Si occupa di rispondere alle chiamate
 * che andranno a modificare la configurazione
 * tramite restcontroller
 * Vedere istruzioni su github
 * @author Andrea Giampieri
 *
 */
@RestController
public class ConfigController {
	
	@GetMapping(value="/addmonitoring",produces = "application/json;")
	public String addCity(@RequestParam(value = "cityid") String cityId) {
		try {
			Config.addCity(Long.parseLong(cityId));
			Config.commit();
			return  Config.toJsonString();
		} catch (NumberFormatException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Numero non valido",e);
		}
	}
	
	@GetMapping(value = "/status",produces = "application/json;")
	public String getStatus() {
		return Config.toJsonString();
	}
	
	@GetMapping(value="/removemonitoring",produces = "application/json;")
	public String df(@RequestParam(value = "cityid") String cityId)  {
		try {
			Config.removeCity(Long.parseLong(cityId));
			Config.commit();
			return  Config.toJsonString();
		} catch (NumberFormatException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "numero non valido", e);
		}
	}

}
