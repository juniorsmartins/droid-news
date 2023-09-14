package io.droidblue.adapters.out;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.droidblue.adapters.out.repository.CustomerRepository;
import io.droidblue.adapters.out.repository.mapper.CustomerEntityMapper;
import io.droidblue.application.core.domain.Customer;
import io.droidblue.application.ports.out.FindCustomerByIdOutputPort;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CustomerEntityMapper customerEntityMapper;

  @Override
  public Optional<Customer> find(String id) {

    var customerEntity = this.customerRepository.findById(id);
    return customerEntity.map(entity -> this.customerEntityMapper.toCustomer(entity));
  }  
}

