package io.droidnewsnews.driven.convertersOut;

import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.driver.dtos.NewsDTOOut;
import io.droidnewsnews.driver.dtos.NewsDTOUpdate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsConverter {

  NewsEntity toEntity(NewsDTOUpdate dto);

  NewsDTOOut toDTO(NewsEntity entity);

  NewsDTOUpdate toDTOUpdate(NewsEntity entity);
}

