package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.application_business_rules.exceptions.http_404.UserNotFoundException;
import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterDAOToEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserGatewayBuscarPorEmailImpl implements UserGatewayBuscarPorEmail {

  private final UserJpa userJpa;

  private final ConverterDAOToEntity converter;

  public UserGatewayBuscarPorEmailImpl(UserJpa userJpa,
                                       ConverterDAOToEntity converter) {
    this.userJpa = userJpa;
    this.converter = converter;
  }

  @Override
  public Optional<UserEntity> buscarPorEmail(final String email) {

    return this.userJpa.findByEmail(email)
      .map(this.converter::converterDaoToEntity);
  }
}

