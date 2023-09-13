package io.droidblue.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.droidblue.adapters.in.controller.mapper.CustomerMapper;
import io.droidblue.adapters.in.controller.request.CustomerRequest;
import io.droidblue.adapters.in.controller.response.CustomerResponse;
import io.droidblue.application.ports.in.FindCustomerByIdInputPort;
import io.droidblue.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;

@RestController
@RequestMapping
public class CustomerController {

  @Autowired
  private InsertCustomerInputPort insertCustomerInputPort;

  @Autowired
  private FindCustomerByIdInputPort findCustomerByIdInputPort;

  @Autowired
  private CustomerMapper customerMapper;
  
  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {

    var customer = this.customerMapper.toCustomer(customerRequest);
    this.insertCustomerInputPort.insert(customer, customerRequest.getZipCode());

    return ResponseEntity
    .status(HttpStatus.CREATED)
    .build();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<CustomerResponse> findById(@PathVariable(name = "id") final String id) {
    
    var customer = this.findCustomerByIdInputPort.find(id);
    var customerResponse = this.customerMapper.toCustomerResponse(customer);

    return ResponseEntity
      .ok()
      .body(customerResponse);
  }
}

