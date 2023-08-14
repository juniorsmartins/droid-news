package oi.droidnewsusers.application_business_rules.exceptions.http_500;

import oi.droidnewsusers.application_business_rules.exceptions.MessageDefault;

public final class DatabaseException extends InternalException {

  public static final long serialVersionUID = 1L;

  public DatabaseException(String message) {
    super(message);
  }

  public DatabaseException() {
    this(String.format(MessageDefault.PROBLEM_LAYER_DATABASE));
  }
}

