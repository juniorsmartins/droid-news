package oi.droidnewsusers.enterprise_business_rules.value_objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import oi.droidnewsusers.application_business_rules.exceptions.http_409.EmailInvalidoException;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@EqualsAndHashCode(of = {"email"})
public final class CorreioEletronico implements Serializable {

  public static final long serialVersionUID = 1L;

  private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

  private String email;

  public CorreioEletronico(String email) {
    if (!this.ehValido(email)) {
      throw new EmailInvalidoException(email);
    }
    this.email = email;
  }

  public boolean ehValido(String email) {
    Pattern pattern = Pattern.compile(EMAIL_REGEX);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }
}

