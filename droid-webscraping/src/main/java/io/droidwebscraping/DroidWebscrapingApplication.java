package io.droidwebscraping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DroidWebscrapingApplication {

	private static final String URL_MINISTERIO_ESPORTE = "https://www.gov.br/esporte/pt-br";

	public static void main(String[] args) {
		SpringApplication.run(DroidWebscrapingApplication.class, args);
	}

}
