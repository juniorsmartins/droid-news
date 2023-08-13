package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGateway;

import java.util.List;
import java.util.UUID;

public interface UserService {

  UserEntity salvar(UserGateway userGateway, UserEntity userEntity);

  UserEntity buscarPorId(UserGateway userGateway, UUID id);

  List<UserEntity> listar(UserGateway userGateway);

  void deleteById(UserGateway userGateway, UUID id);
}

