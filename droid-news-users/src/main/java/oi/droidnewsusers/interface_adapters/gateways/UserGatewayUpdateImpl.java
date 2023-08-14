package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.application_business_rules.exceptions.http_404.UserNotFoundException;
import oi.droidnewsusers.application_business_rules.exceptions.http_500.DatabaseException;
import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterDAOToEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterEntityToDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class UserGatewayUpdateImpl implements UserGatewayUpdate {

  private final UserJpa userJpa;

  private final ConverterEntityToDAO converterEntityToDAO;

  private final ConverterDAOToEntity converterDAOToEntity;

  public UserGatewayUpdateImpl(UserJpa userJpa,
                               ConverterEntityToDAO converterEntityToDAO,
                               ConverterDAOToEntity converterDAOToEntity) {
    this.userJpa = userJpa;
    this.converterEntityToDAO = converterEntityToDAO;
    this.converterDAOToEntity = converterDAOToEntity;
  }

  @Transactional
  @Override
  public UserEntity update(UserEntity userEntity) {

    return Optional.of(userEntity)
      .map(entity -> {
        this.userJpa.findById(entity.getId())
          .orElseThrow(() -> new UserNotFoundException(entity.getId()));
        return entity;
      })
      .map(this.converterEntityToDAO::converterEntityToDao)
      .map(this.userJpa::save)
      .map(this.converterDAOToEntity::converterDaoToEntity)
      .orElseThrow(() -> new DatabaseException());
  }
}

