package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.interface_adapters.gateways.UserGatewayDeleteById;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceDeleteByIdImpl implements UserServiceDeleteById {

  @Transactional(isolation = Isolation.SERIALIZABLE)
  @Override
  public void deleteById(final UserGatewayDeleteById userGateway, final UUID id) {

    userGateway.deleteById(id);
  }
}

