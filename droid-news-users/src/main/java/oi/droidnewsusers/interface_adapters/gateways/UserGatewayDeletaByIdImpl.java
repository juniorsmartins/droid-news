package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.application_business_rules.exceptions.http_404.UserNotFoundException;
import oi.droidnewsusers.application_business_rules.exceptions.http_409.NonDeletableResourceException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public class UserGatewayDeletaByIdImpl implements UserGatewayDeleteById {

  private final UserJpa userJpa;

  public UserGatewayDeletaByIdImpl(UserJpa userJpa) {
    this.userJpa = userJpa;
  }

  @Transactional
  @Override
  public void deleteById(UUID id) {

    this.userJpa.findById(id)
      .map(entity -> {
        this.userJpa.delete(entity);
        return true;
      })
      .orElseThrow(() -> new UserNotFoundException(id));
  }
}

