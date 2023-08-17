package io.droidnewsnews.driven.adapters;

import io.droidnewsnews.core.application.exceptions.http_409.NonDeletableResourceException;
import io.droidnewsnews.core.application.ports.NewsOutputPort;
import io.droidnewsnews.core.domain.NewsFilter;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.driven.convertersOut.NewsConverterOut;
import io.droidnewsnews.driven.specifications.NewsSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class NewsRepositoryImpl implements NewsOutputPort {

  @Autowired
  private NewsJpa newsJpa;

  @Autowired
  private NewsConverterOut converter;

  @Override
  public NewsEntity save(final NewsEntity newsEntity) {

    return Optional.of(newsEntity)
      .map(this.converter::toDAO)
      .map(this.newsJpa::save)
      .map(this.converter::toEntity)
      .orElseThrow();
  }

  @Override
  public Page<NewsEntity> search(final NewsFilter newsFilter, final Pageable pagination) {

    return Optional.of(newsFilter)
      .map(filter -> this.newsJpa.findAll(NewsSpecs.queryDynamically(filter), pagination))
      .map(pageEntities -> pageEntities.map(this.converter::toEntity))
      .orElseThrow();
  }

  @Override
  public Optional<NewsEntity> consult(final UUID id) {

    return Optional.of(id)
      .flatMap(this.newsJpa::findById)
      .map(this.converter::toEntity);
  }

  @Override
  public void delete(NewsEntity newsEntity) {

    Optional.of(newsEntity)
      .map(this.converter::toDAO)
      .map(dao -> {
        this.newsJpa.delete(dao);
        return true;
      })
      .orElseThrow(() -> new NonDeletableResourceException(newsEntity.getId()));
  }
}

