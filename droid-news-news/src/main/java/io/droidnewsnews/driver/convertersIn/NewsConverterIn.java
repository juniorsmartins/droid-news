package io.droidnewsnews.driver.convertersIn;

import io.droidnewsnews.core.domain.filters.NewsFilter;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.driver.dtos.NewsDTOIn;
import io.droidnewsnews.driver.dtos.NewsDTOOut;
import io.droidnewsnews.driver.dtos.NewsDTOUpdate;
import io.droidnewsnews.driver.dtos.NewsFilterDTO;

public interface NewsConverterIn {

  NewsEntity toEntity(NewsDTOIn dto);

  NewsDTOOut toDTO(NewsEntity entity);

  NewsEntity toEntity(NewsDTOUpdate dto);

  NewsFilter toFilter(NewsFilterDTO filterDTO);
}

