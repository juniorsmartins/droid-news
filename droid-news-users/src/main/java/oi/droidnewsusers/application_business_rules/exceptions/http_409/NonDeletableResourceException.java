package oi.droidnewsusers.application_business_rules.exceptions.http_409;

import oi.droidnewsusers.application_business_rules.exceptions.MensagemPadrao;

import java.util.UUID;

public final class NonDeletableResourceException extends RegraDeNegocioVioladaException {

  public static final long serialVersionUID = 1L;

  public NonDeletableResourceException(String message) {
    super(message);
  }

  public NonDeletableResourceException(UUID id) {
    this(String.format(MensagemPadrao.NON_DELETABLE_RESOURCE, id));
  }
}

