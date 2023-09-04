package io.droidblack.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public final class Greeting implements Serializable {
  
  private static final long serialVersionUID=1L;

  private final long id;

  private final String content;
}

