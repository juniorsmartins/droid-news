package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;

import java.util.Optional;

public interface UserGatewayBuscarPorEmail {

  Optional<UserEntity> buscarPorEmail(String email);
}

