package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterDAOToEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserGatewayListarImpl implements UserGatewayListar {

  private final UserJpa userJpa;

  private final ConverterDAOToEntity converterDAOToEntity;

  public UserGatewayListarImpl(UserJpa userJpa,
                               ConverterDAOToEntity converterDAOToEntity) {
    this.userJpa = userJpa;
    this.converterDAOToEntity = converterDAOToEntity;
  }

  @Transactional
  @Override
  public List<UserEntity> listar() {

    return this.userJpa.findAll()
      .stream()
      .map(this.converterDAOToEntity::converterDaoToEntity)
      .toList();
  }
}

