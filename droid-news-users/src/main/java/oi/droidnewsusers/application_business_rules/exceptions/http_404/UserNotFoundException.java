package oi.droidnewsusers.application_business_rules.exceptions.http_404;

import oi.droidnewsusers.application_business_rules.exceptions.MessageDefault;

import java.util.UUID;

public final class UserNotFoundException extends ResourceNotFoundException {

  private static final long serialVersionUID = 1L;

  public UserNotFoundException(String message) {
    super(message);
  }

  public UserNotFoundException(UUID id) {
    this(String.format(MessageDefault.USER_NOT_FOUND, id));
  }
}

