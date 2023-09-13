package io.droidblue.application.ports.in;

import io.droidblue.application.core.domain.Customer;

public interface InsertCustomerInputPort {
  
  void insert(Customer customer, String zipCode);
}

