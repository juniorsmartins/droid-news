package io.droidnewsnews.driver.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public record NewsDTOUpdate(

  @NotNull
  UUID id,

  @Length(max = 20)
  String hat,

  @NotBlank @Length(max = 100)
  String title,

  @NotBlank @Length(max = 200)
  String caption,

  @NotBlank @Length(max = 10000)
  String body
) { }

