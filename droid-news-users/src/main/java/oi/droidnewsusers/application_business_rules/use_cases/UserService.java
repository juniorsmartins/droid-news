package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {

  UserEntity salvar(UserEntity userEntity);

  UserEntity buscarPorId(UUID id);

  List<UserEntity> listar();
}

