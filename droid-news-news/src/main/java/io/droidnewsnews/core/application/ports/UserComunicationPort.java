package io.droidnewsnews.core.application.ports;

import io.droidnewsnews.core.domain.entities.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserComunicationPort {

  Optional<UserEntity> buscarPorId(UUID userId);

  Optional<UserEntity> create(UserEntity userEntity);
}

