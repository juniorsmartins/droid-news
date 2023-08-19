package io.droidnewsnews.driver.dtos;

import io.droidnewsnews.core.domain.entities.NewsUserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record NewsDTOOut(

  UUID id,

  String hat,

  String title,

  String caption,

  String body,

  List<NewsUserEntity> newsUsers
) { }

