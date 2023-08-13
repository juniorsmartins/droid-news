package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.interface_adapters.gateways.UserGatewayDeleteById;

import java.util.UUID;

public interface UserServiceDeleteById {

  void deleteById(UserGatewayDeleteById userGateway, UUID id);
}

