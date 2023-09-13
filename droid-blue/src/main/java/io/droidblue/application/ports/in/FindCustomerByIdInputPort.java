package io.droidblue.application.ports.in;

import io.droidblue.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
  
  Customer find(String id);
}

