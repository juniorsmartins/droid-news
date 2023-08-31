package io.droidwebscraping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.droidwebscraping.services.ServiceScrapingMinisterioEducacao;

@SpringBootApplication
public class DroidWebscrapingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroidWebscrapingApplication.class, args);

		var scraping = new ServiceScrapingMinisterioEducacao();
		scraping.obtainNews();
	}

}

