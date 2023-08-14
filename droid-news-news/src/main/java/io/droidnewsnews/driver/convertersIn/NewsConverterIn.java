package io.droidnewsnews.driver.convertersIn;

import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.driver.dtos.NewsDTOIn;
import io.droidnewsnews.driver.dtos.NewsDTOOut;
import io.droidnewsnews.driver.dtos.NewsDTOUpdate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsConverterIn {

  NewsEntity toEntity(NewsDTOIn dto);

  NewsDTOOut toDTO(NewsEntity entity);

  NewsEntity toEntity(NewsDTOUpdate dto);

  NewsDTOUpdate toDTOUpdate(NewsEntity entity);
}

