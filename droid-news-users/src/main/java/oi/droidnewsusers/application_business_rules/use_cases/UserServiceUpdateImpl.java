package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.application_business_rules.exceptions.http_404.UserNotFoundException;
import oi.droidnewsusers.application_business_rules.use_cases.rules.Rules;
import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayBuscarPorId;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayUpdate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceUpdateImpl implements UserServiceUpdate {

  @Autowired
  private List<Rules> rules;

  @Transactional
  @Override
  public UserEntity update(final UserGatewayUpdate userGateway, final UserGatewayBuscarPorId userGatewayBuscarPorId, final UserEntity userEntity) {

    return Optional.of(userEntity)
      .map(entity -> {
        this.rules.forEach(rule -> rule.executar(entity));
        var register = userGatewayBuscarPorId.buscarPorId(entity.getId());
        BeanUtils.copyProperties(entity, register);
        return register;
      })
      .map(userGateway::update)
      .orElseThrow();
  }
}

