package io.droidnewsnews.core.application.exceptions.http_404;

import io.droidnewsnews.core.application.exceptions.MessageDefault;

import java.util.UUID;

public final class UserNotFoundException extends ResourceNotFoundException {

  private static final long serialVersionUID = 1L;

  public UserNotFoundException(String message) {
    super(message);
  }

  public UserNotFoundException(UUID id) {
    this(String.format(MessageDefault.USER_NOT_FOUND_BY_ID, id));
  }
}

