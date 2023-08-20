package io.droidnewsnews.driven.adapters;

import io.droidnewsnews.core.application.ports.UserOutputPort;
import io.droidnewsnews.core.domain.entities.NewsUserEntity;
import io.droidnewsnews.core.domain.entities.UserEntity;
import io.droidnewsnews.driven.convertersOut.NewsConverterOut;
import io.droidnewsnews.driven.daos.NewsUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserOutputPort {

  @Autowired
  private NewsConverterOut converter;

  @Autowired
  private NewsUserJpa newsUserJpa;

  @Override
  public NewsUserEntity save(final UUID userId) {

    return Optional.of(userId)
      .map(id -> NewsUserDAO.builder()
        .userId(id)
        .build())
      .map(this.newsUserJpa::save)
      .map(this.converter::toEntity)
      .orElseThrow();
  }

  @Override
  public Optional<NewsUserEntity> buscarPorId(UUID userId) {

    return this.newsUserJpa.findByUserId(userId)
      .map(this.converter::toEntity);
  }
}

