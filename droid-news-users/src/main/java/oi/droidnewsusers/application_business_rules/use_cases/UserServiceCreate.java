package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewaySave;

public interface UserServiceCreate {

  UserEntity create(UserGatewaySave userGateway, UserEntity userEntity);
}

