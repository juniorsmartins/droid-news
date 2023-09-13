package io.droidblue.application.core.usecase;

import org.springframework.stereotype.Component;

import io.droidblue.application.core.domain.Customer;
import io.droidblue.application.ports.in.InsertCustomerInputPort;
import io.droidblue.application.ports.out.FindAddressByZipCodeOutputPort;
import io.droidblue.application.ports.out.InsertCustomerOutputPort;

@Component
public final class InsertCustomerUseCase implements InsertCustomerInputPort {

  private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

  private final InsertCustomerOutputPort insertCustomerOutputPort;

  public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                               InsertCustomerOutputPort insertCustomerOutputPort) {
    this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    this.insertCustomerOutputPort = insertCustomerOutputPort;
  }
  
  @Override
  public void insert(Customer customer, String zipCode) {

    var address = this.findAddressByZipCodeOutputPort.find(zipCode);
    customer.setAddress(address);
    this.insertCustomerOutputPort.insert(customer);
  }
}

