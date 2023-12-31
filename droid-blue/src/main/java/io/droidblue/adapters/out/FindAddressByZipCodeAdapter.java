package io.droidblue.adapters.out;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.droidblue.adapters.out.client.FindAddressByZipCodeClient;
import io.droidblue.adapters.out.client.mapper.AddressResponseMapper;
import io.droidblue.application.core.domain.Address;
import io.droidblue.application.ports.out.FindAddressByZipCodeOutputPort;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

  @Autowired
  private FindAddressByZipCodeClient findAddressByZipCodeClient;

  @Autowired
  private AddressResponseMapper addressResponseMapper;

  @Override
  public Address find(String zipCpode) {

    return Optional.of(zipCpode)
    .map(this.findAddressByZipCodeClient::find)
    .map(this.addressResponseMapper::toAddress)
    .orElseThrow();
  }
}

