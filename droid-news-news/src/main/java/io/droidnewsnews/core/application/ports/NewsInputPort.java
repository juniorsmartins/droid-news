package io.droidnewsnews.core.application.ports;

import io.droidnewsnews.core.domain.NewsFilter;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface NewsInputPort {

  NewsEntity create(NewsEntity newsEntity);

  NewsEntity update(NewsEntity newsEntity);

  Page<NewsEntity> search(NewsFilter newsFilter, Pageable pagination);

  void delete(UUID id);
}

