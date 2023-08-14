package io.droidnewsnews.core.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public final class NewsEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID id;

  private String hat;

  private String title;

  private String caption;

  private String body;
}

