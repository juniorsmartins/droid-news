package io.droidblue.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class CustomerRequest {
  
  @NotBlank
  private String name;

  @NotBlank
  private String cpf;

  @NotBlank
  private String zipCode;
}
