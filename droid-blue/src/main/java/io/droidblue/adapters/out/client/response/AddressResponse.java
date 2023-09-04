package io.droidblue.adapters.out.client.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public final class AddressResponse {
  
  private String street;

  private String city;
  
  private String state;
}
