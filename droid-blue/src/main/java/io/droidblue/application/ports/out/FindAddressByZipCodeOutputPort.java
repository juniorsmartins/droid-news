package io.droidblue.application.ports.out;

import io.droidblue.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
  
  Address find(String zipCpode);
}
