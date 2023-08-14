package io.droidnewsnews.driven.adapters;

import io.droidnewsnews.core.application.ports.NewsOutputPort;
import io.droidnewsnews.core.domain.NewsFilter;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public class NewsRepositoryImpl implements NewsOutputPort {

  @Autowired
  private NewsJpa newsJpa;

  @Override
  public NewsEntity create(NewsEntity newsEntity) {
    return null;
  }

  @Override
  public NewsEntity update(NewsEntity newsEntity) {
    return null;
  }

  @Override
  public Page<NewsEntity> search(NewsFilter newsFilter, Pageable pagination) {
    return null;
  }

  @Override
  public Optional<NewsEntity> consult(UUID id) {
    return Optional.empty();
  }

  @Override
  public void delete(NewsEntity newsEntity) {

  }
}

