package io.droidnewsnews.driven.adapters;

import io.droidnewsnews.core.application.ports.NewsOutputPort;
import io.droidnewsnews.core.application.ports.UserComunicationPort;
import io.droidnewsnews.core.domain.entities.UserEntity;
import io.droidnewsnews.driven.convertersOut.NewsConverterOut;
import io.droidnewsnews.driven.daos.NewsUserDAO;
import io.droidnewsnews.driver.dtos.UserInDTO;
import io.droidnewsnews.driver.dtos.UserOutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserComunicationImpl implements UserComunicationPort {

  @Autowired
  private NewsConverterOut converter;

  @Autowired
  private NewsOutputPort newsOutputPort;

  @Autowired
  private UserClientRest userClientRest;

  @Override
  public Optional<UserEntity> buscarPorId(final UUID userId) {

    return Optional.of(userId)
      .map(this.userClientRest::buscarPorId)
      .map(this.converter::toEntity);
  }

  @Override
  public Optional<UserEntity> create(final UserEntity userEntity) {

    return Optional.of(userEntity)
      .map(this.converter::toInDTO)
      .map(this.userClientRest::create)
      .map(this.converter::toEntity);
  }
}
