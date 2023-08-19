package io.droidnewsnews.core.application.ports;

import io.droidnewsnews.core.domain.entities.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserComunicationPort {

  Optional<UserEntity> buscarPorId(UUID userId);

//  Optional<UserEntity> subscribeUser(UserEntity userEntity, UUID newsId);
//
//  Optional<UserEntity> createUser(UserEntity userEntity, UUID newsId);
//
//  Optional<UserEntity> deleteUser(UserEntity userEntity, UUID newsId);
}

