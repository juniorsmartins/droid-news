package io.droidblue.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerMessage {
  
  private String id;

  private String name;

  private String zipCode;

  private String cpf;

  private Boolean isValidCpf;
}

