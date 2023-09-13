package io.droidblue.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.droidblue.adapters.out.repository.CustomerRepository;
import io.droidblue.application.ports.out.DeleteCustomerByIdOutputPort;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public void delete(String id) {

    this.customerRepository.deleteById(id);
  }  
}

