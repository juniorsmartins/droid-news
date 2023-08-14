package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayBuscarPorId;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayUpdate;

public interface UserServiceUpdate {

  UserEntity update(UserGatewayUpdate userGateway, UserGatewayBuscarPorId userGatewayBuscarPorId, UserEntity userEntity);
}

