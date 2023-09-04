package io.droidblue.application.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class Customer {

  private String id;

  private String name;

  private Address address;
  
  private String cpf;

  private Boolean isValidCpf;
  
}

