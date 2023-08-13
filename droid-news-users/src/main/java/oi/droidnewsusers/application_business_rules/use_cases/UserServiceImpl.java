package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGateway;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

  @Transactional
  @Override
  public UserEntity salvar(final UserGateway userGateway, UserEntity userEntity) {

    return userGateway.salvar(userEntity);
  }

  @Transactional
  @Override
  public UserEntity buscarPorId(final UserGateway userGateway, final UUID id) {

    return userGateway.buscarPorId(id);
  }

  @Transactional
  @Override
  public List<UserEntity> listar(final UserGateway userGateway) {

    return userGateway.listar();
  }

  @Transactional
  @Override
  public void deleteById(final UserGateway userGateway, final UUID id) {

    userGateway.deleteById(id);
  }
}

