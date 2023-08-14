package io.droidnewsnews.driver.dtos;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record NewsDTOIn(

  @Length(max = 20)
  String hat,

  @NotBlank @Length(max = 100)
  String title,

  @NotBlank @Length(max = 200)
  String caption,

  @NotBlank @Length(max = 10000)
  String body
) { }

