package io.droidblue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.droidblue.adapters.out.FindCustomerByIdAdapter;
import io.droidblue.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class FindCustomerByIdConfig {
  
  @Bean
  public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {
    return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
  }
}

