package io.droidblue.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.droidblue.adapters.out.repository.CustomerRepository;
import io.droidblue.adapters.out.repository.mapper.CustomerEntityMapper;
import io.droidblue.application.core.domain.Customer;
import io.droidblue.application.ports.out.UpdateCustomerOutputPort;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CustomerEntityMapper customerEntityMapper;

  @Override
  public void update(Customer customer) {

    var customerEntity = this.customerEntityMapper.toCustomerEntity(customer);
    this.customerRepository.save(customerEntity);
  }
}

