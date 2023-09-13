package io.droidblue.application.core.usecase;

import org.springframework.stereotype.Component;

import io.droidblue.application.core.domain.Customer;
import io.droidblue.application.ports.in.FindCustomerByIdInputPort;
import io.droidblue.application.ports.out.FindCustomerByIdOutputPort;

@Component
public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {
  

  private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

  public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
    this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
  }

  @Override
  public Customer find(String id) {
    return this.findCustomerByIdOutputPort.find(id)
      .orElseThrow(() -> new RuntimeException("Customer not found"));
  }
}

