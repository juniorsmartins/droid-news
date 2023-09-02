package oi.droidnewsusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DroidNewsUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroidNewsUsersApplication.class, args);
	}

}

