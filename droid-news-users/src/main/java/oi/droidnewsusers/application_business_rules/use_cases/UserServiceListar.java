package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayListar;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewaySalvar;

import java.util.List;

public interface UserServiceListar {

  List<UserEntity> listar(UserGatewayListar userGateway);
}

