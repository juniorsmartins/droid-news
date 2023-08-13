package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterDAOToEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterEntityToDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserGatewayListarImpl implements UserGatewayListar {

  private UserJpa userJpa;

  private ConverterDAOToEntity converterDAOToEntity;

  public UserGatewayListarImpl(UserJpa userJpa,
                               ConverterEntityToDAO converterEntityToDAO) {
    this.userJpa = userJpa;
    this.converterDAOToEntity = converterDAOToEntity;
  }

  @Transactional
  @Override
  public List<UserEntity> listar() {

    return this.userJpa.findAll()
      .stream()
      .map(this.converterDAOToEntity::converter)
      .toList();
  }
}

