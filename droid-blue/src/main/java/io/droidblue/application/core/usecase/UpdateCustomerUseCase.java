package io.droidblue.application.core.usecase;

import org.springframework.stereotype.Component;

import io.droidblue.application.core.domain.Customer;
import io.droidblue.application.ports.in.FindCustomerByIdInputPort;
import io.droidblue.application.ports.in.UpdateCustomerInputPort;
import io.droidblue.application.ports.out.FindAddressByZipCodeOutputPort;
import io.droidblue.application.ports.out.UpdateCustomerOutputPort;

@Component
public class UpdateCustomerUseCase implements UpdateCustomerInputPort {
  
  private final FindCustomerByIdInputPort findCustomerByIdInputPort;

  private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

  private final UpdateCustomerOutputPort updateCustomerOutputPort;

  public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, 
                               FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, 
                               UpdateCustomerOutputPort updateCustomerOutputPort) {
    this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    this.updateCustomerOutputPort = updateCustomerOutputPort;
  }
 
  @Override
  public void update(Customer customer, String zipCode) {

    this.findCustomerByIdInputPort.find(customer.getId());
    var address = this.findAddressByZipCodeOutputPort.find(zipCode);
    customer.setAddress(address);
    this.updateCustomerOutputPort.update(customer);
  }
}

