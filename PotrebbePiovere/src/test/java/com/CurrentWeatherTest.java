package com;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.exception.CurrentWeatherException;
import com.model.CurrentWeather;
import com.utils.Config;

/**
 * Test per la classe CurrentWeather
 * @author Andrea Giampieri
 *
 */
class CurrentWeatherTest {	
	
	@BeforeAll
	public static void init() {
		try {
		Config.initialize();
		} catch (Exception e) {
			System.out.println("errore esterno al test");
		}
	}
	
	@Test
	@Order(1)
	@DisplayName("Test stringa regolare")
	public void construtor2() {
		String jsonString="{\"dt\":1639608458,\"temp\":8.02,\"id\":6542152,\"pressure\":1031.0}";
		assertDoesNotThrow(() ->  new CurrentWeather(jsonString));
	}

	@SuppressWarnings("unused")
	@Test
	@Order(2)
	@DisplayName("Test lettura stringa vuota")
	public void constructor1() {
		String jsonString="";
		assertThrows(CurrentWeatherException.class, () -> {
			CurrentWeather cw = new CurrentWeather(jsonString);
	  });
	}
	
	@Test
	@Order(3)
	@DisplayName("Test lettura id errato")
	public void constructor3() {
		assertThrows(CurrentWeatherException.class, () -> {
			@SuppressWarnings("unused")
			CurrentWeather cw = new CurrentWeather((long)123);
	  });
	}
	
	@Test
	@Order(4)
	@DisplayName("Test lettura id corretto")
	public void constructor4() {
		assertDoesNotThrow(() ->   new CurrentWeather((long)6542152));
	}
	
	@Test
	@Order(5)
	@DisplayName("Test tojsonstring")
	public void constructor5() {
		String jsonString="{\"dt\":1639608458,\"temp\":8.02,\"id\":6542152,\"pressure\":1031.0}";
		try {
			CurrentWeather cw = new CurrentWeather(jsonString);
			assertEquals(jsonString, cw.toJsonString());
		}
		catch (Exception e) {}
		
	}

}