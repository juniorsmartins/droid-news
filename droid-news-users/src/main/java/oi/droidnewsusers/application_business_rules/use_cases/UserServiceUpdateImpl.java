package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.application_business_rules.exceptions.http_404.UserNotFoundException;
import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayBuscarPorId;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayUpdate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceUpdateImpl implements UserServiceUpdate {

  @Transactional
  @Override
  public UserEntity update(final UserGatewayUpdate userGateway, final UserGatewayBuscarPorId userGatewayBuscarPorId, final UserEntity userEntity) {

    return Optional.of(userEntity)
      .map(entity -> {
        var register = userGatewayBuscarPorId.buscarPorId(entity.getId());
        BeanUtils.copyProperties(entity, register);
        return register;
      })
      .map(userGateway::update)
      .orElseThrow();
  }
}

