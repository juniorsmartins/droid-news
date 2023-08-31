package io.droidwebscraping.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public final class NewsDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String hat;

  private String title;

  private String caption;

  private String body;

  private String dataPublicacao;

  private String author;

  private String font;

  private String url;
}

