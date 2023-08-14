package io.droidnewsnews.core.domain.entities;

import java.io.Serializable;
import java.util.UUID;

public final class NewsEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID id;

  private String hat;

  private String title;

  private String caption;

  private String body;
}

