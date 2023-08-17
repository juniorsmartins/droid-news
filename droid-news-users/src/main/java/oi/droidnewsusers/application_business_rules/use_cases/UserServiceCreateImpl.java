package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.application_business_rules.use_cases.rules.Rules;
import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewaySave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceCreateImpl implements UserServiceCreate {

  @Autowired
  private List<Rules> rules;

  @Transactional
  @Override
  public UserEntity create(final UserGatewaySave userGateway, final UserEntity userEntity) {

    this.rules.forEach(rule -> rule.executar(userEntity));
    return userGateway.save(userEntity);
  }
}

