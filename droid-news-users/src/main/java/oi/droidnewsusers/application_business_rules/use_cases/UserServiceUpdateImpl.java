package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayUpdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceUpdateImpl implements UserServiceUpdate {

  @Transactional
  @Override
  public UserEntity update(final UserGatewayUpdate userGateway, final UserEntity userEntity) {

    return userGateway.update(userEntity);
  }
}

