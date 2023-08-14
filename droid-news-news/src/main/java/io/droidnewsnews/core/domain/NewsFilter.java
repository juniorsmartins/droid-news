package io.droidnewsnews.core.domain;

import java.util.UUID;

public record NewsFilter(

  UUID id,

  String hat,

  String title,

  String caption,

  String body
) { }

