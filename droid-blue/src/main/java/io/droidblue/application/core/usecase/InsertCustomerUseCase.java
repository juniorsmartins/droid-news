package io.droidblue.application.core.usecase;

import org.springframework.stereotype.Service;

import io.droidblue.application.core.domain.Customer;
import io.droidblue.application.ports.out.FindAddressByZipCodeOutputPort;
import io.droidblue.application.ports.out.InsertCustomerOutputPort;

@Service
public final class InsertCustomerUseCase {

  private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

  private final InsertCustomerOutputPort insertCustomerOutputPort;

  public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                               InsertCustomerOutputPort insertCustomerOutputPort) {
    this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    this.insertCustomerOutputPort = insertCustomerOutputPort;
  }
  
  public void insert(Customer customer, String zipCode) {

    var address = this.findAddressByZipCodeOutputPort.find(zipCode);
    customer.setAddress(address);
    this.insertCustomerOutputPort.insert(customer);
  }
}

