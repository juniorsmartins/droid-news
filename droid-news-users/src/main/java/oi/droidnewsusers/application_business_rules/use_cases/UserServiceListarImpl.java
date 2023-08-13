package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayListar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceListarImpl implements UserServiceListar {

  @Transactional(readOnly = true)
  @Override
  public List<UserEntity> listar(final UserGatewayListar userGateway) {

    return userGateway.listar();
  }
}

