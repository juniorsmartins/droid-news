package io.droidblack.controllers;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public final class Greeting implements Serializable {
  
  private static final long serialVersionUID=1L;

  private final long id;

  private final String content;
}

