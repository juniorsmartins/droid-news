package io.droidblue.application.ports.out;

import io.droidblue.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
  
  void insert(Customer customer);
}
