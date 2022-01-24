package com;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.utils.Config;

/**
 * Test per la classe config
 * @author Andrea Giampieri
 *
 */
class ConfigTest {
	
	@Test
	@Order(1)
	@DisplayName("Test lettura parametro vuoto")
	public void configReadparam() {
		try {
			Config.initialize();
			assertEquals(null, Config.getConf("asdd"));
		} catch (Exception e) {
			
		}
	}	
	
	@Test
	@Order(2)
	@DisplayName("Test lettura configurazione")
	public void configReadUnavailable() {
		assertDoesNotThrow(() -> Config.initialize());
	}


}