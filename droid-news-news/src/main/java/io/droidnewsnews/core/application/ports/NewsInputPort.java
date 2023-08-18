package io.droidnewsnews.core.application.ports;

import io.droidnewsnews.core.domain.entities.UserEntity;
import io.droidnewsnews.core.domain.filters.NewsFilter;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface NewsInputPort {

  NewsEntity create(NewsEntity newsEntity);

  NewsEntity update(NewsEntity newsEntity);

  Page<NewsEntity> search(NewsFilter newsFilter, Pageable pagination);

  void delete(UUID id);

  Optional<UserEntity> subscribeUser(UserEntity userEntity, UUID newsId);

  Optional<UserEntity> createUser(UserEntity userEntity, UUID newsId);

  Optional<UserEntity> deleteUser(UserEntity userEntity, UUID newsId);
}

