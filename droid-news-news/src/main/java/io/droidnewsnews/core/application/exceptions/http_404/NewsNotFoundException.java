package io.droidnewsnews.core.application.exceptions.http_404;

import io.droidnewsnews.core.application.exceptions.MessageDefault;

import java.util.UUID;

public final class NewsNotFoundException extends ResourceNotFoundException {

  private static final long serialVersionUID = 1L;

  public NewsNotFoundException(String message) {
    super(message);
  }

  public NewsNotFoundException(UUID id) {
    this(String.format(MessageDefault.NEWS_NOT_FOUND, id));
  }
}

