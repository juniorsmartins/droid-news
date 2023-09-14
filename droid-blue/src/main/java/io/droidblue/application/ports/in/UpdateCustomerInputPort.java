package io.droidblue.application.ports.in;

import io.droidblue.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
  
  void update(Customer customer, String zipCode);
}

