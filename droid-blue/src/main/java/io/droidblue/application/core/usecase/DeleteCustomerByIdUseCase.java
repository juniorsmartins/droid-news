package io.droidblue.application.core.usecase;

import org.springframework.stereotype.Component;

import io.droidblue.application.ports.in.FindCustomerByIdInputPort;
import io.droidblue.application.ports.out.DeleteCustomerByIdOutputPort;

@Component
public class DeleteCustomerByIdUseCase {
  
  private final FindCustomerByIdInputPort findCustomerByIdInputPort;

  private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

  public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, 
                                   DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
    this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
  }

  public void delete(String id) {
    this.findCustomerByIdInputPort.find(id);
    this.deleteCustomerByIdOutputPort.delete(id);
  }
}

