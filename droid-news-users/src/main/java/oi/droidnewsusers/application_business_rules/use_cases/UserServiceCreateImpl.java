package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewaySave;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceCreateImpl implements UserServiceCreate {

  @Transactional
  @Override
  public UserEntity create(final UserGatewaySave userGateway, final UserEntity userEntity) {

    return userGateway.save(userEntity);
  }
}

