package io.droidblue.application.core.usecase;

import io.droidblue.application.core.domain.Customer;
import io.droidblue.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase {
  

  private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

  public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
    this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
  }

  public Customer find(String id) {
    return this.findCustomerByIdOutputPort.find(id)
    .orElseThrow(() -> new RuntimeException("Customer not found"));
  }
}

