package io.droidblue.adapters.out.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.droidblue.adapters.out.client.response.AddressResponse;

@FeignClient(name = "FindAddressByZipCodeClient", url = "${blue.client.address.url}")
public interface FindAddressByZipCodeClient {
  
  @GetMapping(path = "/{zipCode}")
  AddressResponse find(@PathVariable(name = "zipCode") String zipCode);
}

