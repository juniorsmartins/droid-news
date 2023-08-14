package io.droidnewsnews.core.application.use_cases;

import io.droidnewsnews.core.application.ports.NewsInputPort;
import io.droidnewsnews.core.application.ports.NewsOutputPort;
import io.droidnewsnews.core.domain.NewsFilter;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class NewsServiceImpl implements NewsInputPort {

  @Autowired
  private NewsOutputPort outputPort;

  @Override
  public NewsEntity create(final NewsEntity newsEntity) {

    return Optional.of(newsEntity)
      .map(this.outputPort::create)
      .orElseThrow();
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
  public void delete(UUID id) {

  }
}

