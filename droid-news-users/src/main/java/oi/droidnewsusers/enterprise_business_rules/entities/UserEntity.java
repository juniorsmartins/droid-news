package oi.droidnewsusers.enterprise_business_rules.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oi.droidnewsusers.enterprise_business_rules.value_objects.CorreioEletronico;

import java.io.Serializable;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public final class UserEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID id;

  private String fullName;

  private CorreioEletronico email;

  private String password;

  public void setEmail(String email) {
    this.email = new CorreioEletronico(email);
  }

  public String getEmail() {
    return this.email.getEmail();
  }
}

