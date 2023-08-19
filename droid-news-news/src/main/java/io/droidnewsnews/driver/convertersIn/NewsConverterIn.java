package io.droidnewsnews.driver.convertersIn;

import io.droidnewsnews.core.domain.entities.UserEntity;
import io.droidnewsnews.core.domain.filters.NewsFilter;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.driver.dtos.NewsDTOIn;
import io.droidnewsnews.driver.dtos.NewsDTOOut;
import io.droidnewsnews.driver.dtos.NewsDTOUpdate;
import io.droidnewsnews.driver.dtos.NewsFilterDTO;
import io.droidnewsnews.driver.dtos.UserInDTO;
import io.droidnewsnews.driver.dtos.UserOutDTO;

public interface NewsConverterIn {

  NewsEntity toEntity(NewsDTOIn dto);

  NewsDTOOut toDTO(NewsEntity entity);

  NewsEntity toEntity(NewsDTOUpdate dto);

  NewsFilter toFilter(NewsFilterDTO filterDTO);

  UserEntity toEntity(UserInDTO dto);

  UserOutDTO toDTO(UserEntity entity);
}

