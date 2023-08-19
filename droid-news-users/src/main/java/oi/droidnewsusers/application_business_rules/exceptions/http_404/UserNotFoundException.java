package oi.droidnewsusers.application_business_rules.exceptions.http_404;

import oi.droidnewsusers.application_business_rules.exceptions.MessageDefault;

import java.util.UUID;

public final class UserNotFoundException extends ResourceNotFoundException {

  private static final long serialVersionUID = 1L;

  public UserNotFoundException(String email) {
    super(String.format(MessageDefault.USER_NOT_FOUND_BY_EMAIL, email));
  }

  public UserNotFoundException(UUID id) {
    this(String.format(MessageDefault.USER_NOT_FOUND_BY_ID, id));
  }
}

