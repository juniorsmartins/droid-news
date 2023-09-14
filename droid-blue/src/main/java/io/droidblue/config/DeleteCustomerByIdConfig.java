package io.droidblue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.droidblue.adapters.out.DeleteCustomerByIdAdapter;
import io.droidblue.application.core.usecase.DeleteCustomerByIdUseCase;
import io.droidblue.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class DeleteCustomerByIdConfig {

  @Bean
  public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase, 
                                                             DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
    return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
  }
}

