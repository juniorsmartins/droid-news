package io.droidnewsnews.core.application.exceptions.http_409;

public abstract class BusinessRulesVioladaException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public BusinessRulesVioladaException(String message) {
    super(message);
  }
}

