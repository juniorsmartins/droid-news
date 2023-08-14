package oi.droidnewsusers.application_business_rules.use_cases;

import oi.droidnewsusers.interface_adapters.gateways.UserGatewayBuscarPorId;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayDelete;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceDeleteByIdImpl implements UserServiceDeleteById {

  @Transactional(isolation = Isolation.SERIALIZABLE)
  @Override
  public void deleteById(final UserGatewayDelete userGatewayDelete,
                         final UserGatewayBuscarPorId userGatewayBuscarPorId, final UUID id) {

    Optional.of(id)
        .map(userGatewayBuscarPorId::buscarPorId)
        .map(entity -> {
          userGatewayDelete.delete(entity);
          return true;
        });
  }
}

