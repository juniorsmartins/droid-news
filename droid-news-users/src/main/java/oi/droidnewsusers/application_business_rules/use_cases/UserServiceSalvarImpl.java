package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewaySalvar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceSalvarImpl implements UserServiceSalvar {

  @Transactional
  @Override
  public UserEntity salvar(final UserGatewaySalvar userGateway, UserEntity userEntity) {

    return userGateway.salvar(userEntity);
  }
}

