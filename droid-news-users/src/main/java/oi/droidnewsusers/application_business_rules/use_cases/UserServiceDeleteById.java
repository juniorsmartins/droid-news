package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.interface_adapters.gateways.UserGatewayBuscarPorId;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayDelete;

import java.util.UUID;

public interface UserServiceDeleteById {

  void deleteById(UserGatewayDelete userGatewayDelete, UserGatewayBuscarPorId userGatewayBuscarPorId, UUID id);
}

