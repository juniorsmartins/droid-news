package io.droidnewsnews.driven.convertersOut;

import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.driven.daos.NewsDAO;
import io.droidnewsnews.driver.dtos.NewsDTOOut;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface NewsConverterOut {

  NewsDAO toDAO(NewsEntity newsEntity);

  NewsEntity toEntity(NewsDAO newsDAO);

  Page<NewsEntity> toPageEntity(Page<NewsDAO> daos);
}

