package io.droidblue.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import io.droidblue.adapters.out.repository.entity.CustomerEntity;
import io.droidblue.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
 
  CustomerEntity toCustomerEntity(Customer customer);

  Customer toCustomer(CustomerEntity customerEntity);
}

