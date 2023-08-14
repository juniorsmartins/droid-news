package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;

public interface UserGatewaySave {

  UserEntity save(UserEntity userEntity);
}

