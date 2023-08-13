package oi.droidnewsusers.application_business_rules.exceptions.http_409;

import oi.droidnewsusers.application_business_rules.exceptions.MensagemPadrao;

public final class EmailInvalidoException extends RegraDeNegocioVioladaException {

  public static final long serialVersionUID = 1L;

  public EmailInvalidoException(String email) {
    super(String.format(MensagemPadrao.INVALID_EMAIL, email));
  }
}

