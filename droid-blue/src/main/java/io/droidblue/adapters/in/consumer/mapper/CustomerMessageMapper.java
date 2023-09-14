package io.droidblue.adapters.in.consumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.droidblue.adapters.in.consumer.message.CustomerMessage;
import io.droidblue.application.core.domain.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {
  
  @Mapping(target = "address", ignore = true)
  Customer toCustomer(CustomerMessage customerMessage);
}

