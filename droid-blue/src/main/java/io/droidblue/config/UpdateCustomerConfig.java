package io.droidblue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.droidblue.adapters.out.FindAddressByZipCodeAdapter;
import io.droidblue.adapters.out.UpdateCustomerAdapter;
import io.droidblue.application.core.usecase.FindCustomerByIdUseCase;
import io.droidblue.application.core.usecase.UpdateCustomerUseCase;

@Configuration
public class UpdateCustomerConfig {
  
  @Bean
  public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase, 
                                                     FindAddressByZipCodeAdapter findAddressByZipCodeAdapter, 
                                                     UpdateCustomerAdapter updateCustomerAdapter) {
    return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
  }
}

