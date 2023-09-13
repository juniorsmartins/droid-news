package io.droidblue.application.core.usecase;

import io.droidblue.application.ports.in.DeleteCustomerByIdInputPort;
import io.droidblue.application.ports.in.FindCustomerByIdInputPort;
import io.droidblue.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {
  
  private final FindCustomerByIdInputPort findCustomerByIdInputPort;

  private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

  public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, 
                                   DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
    this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
  }

  @Override
  public void delete(String id) {
    this.findCustomerByIdInputPort.find(id);
    this.deleteCustomerByIdOutputPort.delete(id);
  }
}

