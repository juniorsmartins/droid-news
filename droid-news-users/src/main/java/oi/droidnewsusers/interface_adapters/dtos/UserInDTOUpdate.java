package oi.droidnewsusers.interface_adapters.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public final class UserInDTOUpdate implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  private UUID id;

  @NotBlank
  private String fullName;

  @NotBlank
  @Email
  private String email;

  @NotBlank
  private String password;
}

