package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.application_business_rules.exceptions.http_409.NonDeletableResourceException;
import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterEntityToDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class UserGatewayDeletaImpl implements UserGatewayDelete {

  private final UserJpa userJpa;

  private final ConverterEntityToDAO converterEntityToDAO;

  public UserGatewayDeletaImpl(UserJpa userJpa,
                               ConverterEntityToDAO converterEntityToDAO) {
    this.userJpa = userJpa;
    this.converterEntityToDAO = converterEntityToDAO;
  }

  @Transactional
  @Override
  public void delete(final UserEntity userEntity) {

    Optional.of(userEntity)
      .map(this.converterEntityToDAO::converterEntityToDao)
      .map(dao -> {
        this.userJpa.delete(dao);
        return true;
      })
      .orElseThrow(() -> new NonDeletableResourceException(userEntity.getId()));
  }
}

