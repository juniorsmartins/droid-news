package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayBuscarPorId;

import java.util.UUID;

public interface UserServiceBuscarPorId {

  UserEntity buscarPorId(UserGatewayBuscarPorId userGateway, UUID id);
}

