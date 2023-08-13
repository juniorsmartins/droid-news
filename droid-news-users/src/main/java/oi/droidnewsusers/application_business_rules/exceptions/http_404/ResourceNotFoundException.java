package oi.droidnewsusers.application_business_rules.exceptions.http_404;

public abstract class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(String mensagem) {
    super(mensagem);
  }
}

