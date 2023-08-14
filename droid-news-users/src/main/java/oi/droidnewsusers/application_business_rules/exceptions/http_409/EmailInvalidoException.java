package oi.droidnewsusers.application_business_rules.exceptions.http_409;

import oi.droidnewsusers.application_business_rules.exceptions.MessageDefault;

public final class EmailInvalidoException extends RegraDeNegocioVioladaException {

  public static final long serialVersionUID = 1L;

  public EmailInvalidoException(String email) {
    super(String.format(MessageDefault.INVALID_EMAIL, email));
  }
}

