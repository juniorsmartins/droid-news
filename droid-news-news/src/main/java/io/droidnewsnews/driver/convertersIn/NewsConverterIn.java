package io.droidnewsnews.driver.convertersIn;

import io.droidnewsnews.core.domain.NewsFilter;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.driver.dtos.NewsDTOIn;
import io.droidnewsnews.driver.dtos.NewsDTOOut;
import io.droidnewsnews.driver.dtos.NewsDTOUpdate;
import io.droidnewsnews.driver.dtos.NewsFilterDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface NewsConverterIn {

  NewsEntity toEntity(NewsDTOIn dto);

  NewsDTOOut toDTO(NewsEntity entity);

  NewsEntity toEntity(NewsDTOUpdate dto);

  NewsFilter toFilter(NewsFilterDTO filterDTO);

  Page<NewsDTOOut> toPageDTOOut(Page<NewsEntity> entities);
}

