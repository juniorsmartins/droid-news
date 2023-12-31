package io.droidblue.application.core.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public final class Customer {

  private String id;

  private String name;

  private Address address;
  
  private String cpf;

  private Boolean isValidCpf;
  
  public Customer() {
    this.isValidCpf = false;
  }
}

