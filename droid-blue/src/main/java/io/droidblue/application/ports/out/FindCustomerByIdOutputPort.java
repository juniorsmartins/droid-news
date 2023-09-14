package io.droidblue.application.ports.out;

import java.util.Optional;

import io.droidblue.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {
  
  Optional<Customer> find(String id); 
}

