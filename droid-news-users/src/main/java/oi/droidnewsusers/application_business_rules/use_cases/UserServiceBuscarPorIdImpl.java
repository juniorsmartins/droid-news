package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayBuscarPorId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceBuscarPorIdImpl implements UserServiceBuscarPorId {

  @Transactional(readOnly = true)
  @Override
  public UserEntity buscarPorId(final UserGatewayBuscarPorId userGateway, final UUID id) {

    return userGateway.buscarPorId(id);
  }
}

