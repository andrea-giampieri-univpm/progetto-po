package com;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.exception.ConfigException;
import com.utils.Config;

@SpringBootApplication
@EnableScheduling
public class PotrebbePiovere {

	public static void main(String[] args) throws IOException {
		//AG: inizializzo configurazione, se non c'è viene terminata l'app
				try {
					Config.initialize();
				} catch (ConfigException e) {
					System.out.println(e);
					System.exit(1);
				}
				
		SpringApplication.run(PotrebbePiovere.class, args);

	}

}
