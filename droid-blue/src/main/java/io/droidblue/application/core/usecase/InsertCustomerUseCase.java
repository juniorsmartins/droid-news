package io.droidblue.application.core.usecase;

import io.droidblue.application.core.domain.Customer;
import io.droidblue.application.ports.in.InsertCustomerInputPort;
import io.droidblue.application.ports.out.FindAddressByZipCodeOutputPort;
import io.droidblue.application.ports.out.InsertCustomerOutputPort;
import io.droidblue.application.ports.out.SendCpfForValidationOutputPort;

public final class InsertCustomerUseCase implements InsertCustomerInputPort {

  private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

  private final InsertCustomerOutputPort insertCustomerOutputPort;

  private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

  public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                               InsertCustomerOutputPort insertCustomerOutputPort, 
                               SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
    this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    this.insertCustomerOutputPort = insertCustomerOutputPort;
    this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
  }
  
  @Override
  public void insert(Customer customer, String zipCode) {

    var address = this.findAddressByZipCodeOutputPort.find(zipCode);
    customer.setAddress(address);
    this.insertCustomerOutputPort.insert(customer);
    this.sendCpfForValidationOutputPort.send(customer.getCpf());
  }
}

