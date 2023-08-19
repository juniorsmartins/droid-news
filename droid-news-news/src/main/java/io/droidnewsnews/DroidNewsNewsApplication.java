package io.droidnewsnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DroidNewsNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroidNewsNewsApplication.class, args);
	}

}
