package io.droidnewsnews.core.application.ports;

import io.droidnewsnews.core.domain.NewsFilter;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface NewsOutputPort {

  NewsEntity save(NewsEntity newsEntity);

  Page<NewsEntity> search(NewsFilter newsFilter, Pageable pagination);

  Optional<NewsEntity> consult(UUID id);

  void delete(NewsEntity newsEntity);
}

