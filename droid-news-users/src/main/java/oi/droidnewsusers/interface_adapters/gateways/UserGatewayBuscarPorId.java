package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;

import java.util.UUID;

public interface UserGatewayBuscarPorId {

  UserEntity buscarPorId(UUID id);
}

