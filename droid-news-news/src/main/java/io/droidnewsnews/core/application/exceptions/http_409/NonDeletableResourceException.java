package io.droidnewsnews.core.application.exceptions.http_409;

import oi.droidnewsusers.application_business_rules.exceptions.MessageDefault;

import java.util.UUID;

public final class NonDeletableResourceException extends BusinessRulesVioladaException {

  public static final long serialVersionUID = 1L;

  public NonDeletableResourceException(String message) {
    super(message);
  }

  public NonDeletableResourceException(UUID id) {
    this(String.format(MessageDefault.NON_DELETABLE_RESOURCE, id));
  }
}

