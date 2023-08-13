package oi.droidnewsusers.interface_adapters.dtos;

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
public final class UserInDTOImpl implements Serializable, UserInDTO {

  private static final long serialVersionUID = 1L;

  private UUID id;

  private String fullName;

  private String email;

  private String password;
}

