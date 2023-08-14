package io.droidnewsnews.driver.dtos;

import java.util.UUID;

public record NewsDTOUpdate(

  UUID id,

  String hat,

  String title,

  String caption,

  String body
) { }

