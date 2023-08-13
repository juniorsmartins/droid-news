package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterDAOToEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterEntityToDAO;
import oi.droidnewsusers.interface_adapters.converters.ConverterPageEntitiesToPageDAOs;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class UserGatewayImpl implements UserGateway {

  private UserJpa userJpa;

  private ConverterEntityToDAO converterEntityToDAO;

  private ConverterDAOToEntity converterDAOToEntity;

  private ConverterPageEntitiesToPageDAOs converterPageEntitiesToPageDAOs;

  public UserGatewayImpl(UserJpa userJpa,
                         ConverterEntityToDAO converterEntityToDAO,
                         ConverterDAOToEntity converterDAOToEntity,
                         ConverterPageEntitiesToPageDAOs converterPageEntitiesToPageDAOs) {
    this.userJpa = userJpa;
    this.converterEntityToDAO = converterEntityToDAO;
    this.converterDAOToEntity = converterDAOToEntity;
    this.converterPageEntitiesToPageDAOs = converterPageEntitiesToPageDAOs;
  }

  @Transactional
  @Override
  public UserEntity salvar(UserEntity userEntity) {

    return Optional.of(userEntity)
      .map(this.converterEntityToDAO::converter)
      .map(this.userJpa::save)
      .map(this.converterDAOToEntity::converter)
      .orElseThrow();
  }
}

