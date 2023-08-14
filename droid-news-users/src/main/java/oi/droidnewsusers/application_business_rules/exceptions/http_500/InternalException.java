package oi.droidnewsusers.application_business_rules.exceptions.http_500;

public abstract class InternalException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public InternalException(String message) {
    super(message);
  }
}

