package io.droidblue.adapters.out.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Document(collection = "customers")
public final class CustomerEntity {
  
  @Id
  private String id;

  private String name;

  private AddressEntity address;

  private String cpf;

  private Boolean isValidCpf;
}

