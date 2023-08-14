package io.droidnewsnews.driven.convertersOut;

import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.driven.daos.NewsDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsConverterOut {

  NewsDAO toDAO(NewsEntity newsEntity);

  NewsEntity toEntity(NewsDAO newsDAO);
}

