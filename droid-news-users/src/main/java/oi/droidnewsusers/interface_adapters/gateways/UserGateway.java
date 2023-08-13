package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserGateway {

  UserEntity salvar(UserEntity userEntity);

  UserEntity buscarPorId(UUID id);

  List<UserEntity> listar();

  void deleteById(final UUID id);
}

