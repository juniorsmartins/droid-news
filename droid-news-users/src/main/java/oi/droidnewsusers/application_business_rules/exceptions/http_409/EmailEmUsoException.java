package oi.droidnewsusers.application_business_rules.exceptions.http_409;

import oi.droidnewsusers.application_business_rules.exceptions.MessageDefault;

public final class EmailEmUsoException extends RegraDeNegocioVioladaException {

  public static final long serialVersionUID = 1L;

  public EmailEmUsoException(String email) {
    super(String.format(MessageDefault.EMAIL_IN_USE, email));
  }
}

