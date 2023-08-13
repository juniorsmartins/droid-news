package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.application_business_rules.exceptions.http_404.UserNotFoundException;
import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterDAOToEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public class UserGatewayBuscarPorIdImpl implements UserGatewayBuscarPorId {

  private UserJpa userJpa;

  private ConverterDAOToEntity converterDAOToEntity;

  public UserGatewayBuscarPorIdImpl(UserJpa userJpa,
                         ConverterDAOToEntity converterDAOToEntity) {
    this.userJpa = userJpa;
    this.converterDAOToEntity = converterDAOToEntity;
  }

  @Transactional
  @Override
  public UserEntity buscarPorId(final UUID id) {

    return this.userJpa.findById(id)
      .map(this.converterDAOToEntity::converter)
      .orElseThrow(() -> new UserNotFoundException(id));
  }
}

