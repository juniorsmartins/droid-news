package io.droidblue.adapters.in.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
  
  private String name;

  private AddressResponse address;

  private String cpf;

  private Boolean isValidCpf;
}

