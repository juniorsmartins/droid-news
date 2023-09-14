package io.droidblue.application.ports.out;

import io.droidblue.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
  
  void update(Customer customer);
}

