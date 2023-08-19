package oi.droidnewsusers.application_business_rules.use_cases.rules;

import oi.droidnewsusers.application_business_rules.exceptions.http_409.EmailEmUsoException;
import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayBuscarPorEmail;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class RuleEmailUnique implements Rules {

  private final UserGatewayBuscarPorEmail userGateway;

  public RuleEmailUnique(UserGatewayBuscarPorEmail userGateway) {
    this.userGateway = userGateway;
  }

  @Override
  public void executar(final UserEntity userEntity) {

    var emailExist = this.userGateway.buscarPorEmail(userEntity.getEmail())
      .filter(entityDatabase -> !entityDatabase.getId().equals(userEntity.getId()))
      .isPresent();

    if (emailExist) {
      throw new EmailEmUsoException(userEntity.getEmail());
    }
  }
}

