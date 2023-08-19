package io.droidnewsnews.core.application.exceptions.http_409;

import io.droidnewsnews.core.application.exceptions.MessageDefault;

public final class EmailInvalidoException extends BusinessRulesVioladaException {

  public static final long serialVersionUID = 1L;

  public EmailInvalidoException(String email) {
    super(String.format(MessageDefault.INVALID_EMAIL, email));
  }
}

