package io.droidblue.adapters.out.client.mapper;

import org.mapstruct.Mapper;

import io.droidblue.adapters.out.client.response.AddressResponse;
import io.droidblue.application.core.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
  
  Address toAddress(AddressResponse addressResponse);
}

