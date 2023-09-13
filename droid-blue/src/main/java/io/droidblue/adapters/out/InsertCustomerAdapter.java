package io.droidblue.adapters.out;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.droidblue.adapters.out.repository.CustomerRepository;
import io.droidblue.adapters.out.repository.mapper.CustomerEntityMapper;
import io.droidblue.application.core.domain.Customer;
import io.droidblue.application.ports.out.InsertCustomerOutputPort;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CustomerEntityMapper customerEntityMapper;

  @Override
  public void insert(Customer customer) {

    Optional.of(customer)
    .map(this.customerEntityMapper::toCustomerEntity)
    .map(this.customerRepository::save)
    .orElseThrow(); 
  }
  
}
