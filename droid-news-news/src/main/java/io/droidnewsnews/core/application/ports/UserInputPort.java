package io.droidnewsnews.core.application.ports;

import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.core.domain.entities.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserInputPort {

  NewsEntity subscribeUser(UUID newsId, UUID userId);

  void unsubscribeUser(UUID newsId, UUID userId);

  UserEntity createUser(UserEntity userEntity, UUID newsId);
}

