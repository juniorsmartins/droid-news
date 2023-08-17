package io.droidnewsnews.core.application.use_cases;

import io.droidnewsnews.core.application.exceptions.http_404.NewsNotFoundException;
import io.droidnewsnews.core.application.ports.NewsInputPort;
import io.droidnewsnews.core.application.ports.NewsOutputPort;
import io.droidnewsnews.core.domain.NewsFilter;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class NewsServiceImpl implements NewsInputPort {

  @Autowired
  private NewsOutputPort outputPort;

  @Transactional
  @Override
  public NewsEntity create(final NewsEntity newsEntity) {

    return Optional.of(newsEntity)
      .map(this.outputPort::save)
      .orElseThrow();
  }

  @Transactional
  @Override
  public NewsEntity update(NewsEntity newsEntity) {

    return Optional.of(newsEntity)
      .map(entity -> {
        var register = this.consultNews(entity.getId());
        BeanUtils.copyProperties(entity, register);
        return register;
      })
      .map(this.outputPort::save)
      .orElseThrow();
  }

  @Transactional(readOnly = true)
  @Override
  public Page<NewsEntity> search(final NewsFilter newsFilter, final Pageable pagination) {

    return Optional.of(newsFilter)
      .map(filter -> this.outputPort.search(filter, pagination))
      .orElseThrow();
  }

  @Transactional(isolation = Isolation.SERIALIZABLE)
  @Override
  public void delete(final UUID id) {

    this.outputPort.delete(this.consultNews(id));
  }

  private NewsEntity consultNews(final UUID id) {
    return this.outputPort.consult(id)
      .orElseThrow(() -> new NewsNotFoundException(id));
  }
}

