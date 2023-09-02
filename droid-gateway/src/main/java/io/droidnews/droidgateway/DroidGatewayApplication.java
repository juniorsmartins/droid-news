package io.droidnews.droidgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@SpringBootApplication
public class DroidGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroidGatewayApplication.class, args);
	}

}

