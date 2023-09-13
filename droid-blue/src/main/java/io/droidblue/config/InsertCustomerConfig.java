package io.droidblue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.droidblue.adapters.out.FindAddressByZipCodeAdapter;
import io.droidblue.adapters.out.InsertCustomerAdapter;
import io.droidblue.application.core.usecase.InsertCustomerUseCase;

@Configuration
public class InsertCustomerConfig {
  
  @Bean
  public InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter, 
                                                     InsertCustomerAdapter insertCustomerAdapter) {
    return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
  }
}

