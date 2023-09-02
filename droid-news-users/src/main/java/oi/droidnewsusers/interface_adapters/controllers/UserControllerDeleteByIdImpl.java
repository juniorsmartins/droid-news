package oi.droidnewsusers.interface_adapters.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oi.droidnewsusers.application_business_rules.use_cases.UserServiceDeleteById;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayBuscarPorId;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayDelete;

@RestController
@RequestMapping
public final class UserControllerDeleteByIdImpl implements UserController.UserControllerDeleteById {

  private final UserServiceDeleteById userServiceDeleteById;

  private final UserGatewayDelete userGatewayDelete;

  private final UserGatewayBuscarPorId userGatewayBuscarPorId;

  public UserControllerDeleteByIdImpl(UserServiceDeleteById userServiceDeleteById,
                                      UserGatewayDelete userGatewayDelete,
                                      UserGatewayBuscarPorId userGatewayBuscarPorId) {
    this.userServiceDeleteById = userServiceDeleteById;
    this.userGatewayDelete = userGatewayDelete;
    this.userGatewayBuscarPorId = userGatewayBuscarPorId;
  }

  @Override
  public ResponseEntity<Object> deleteById(@PathVariable(name = "id") UUID id) {

    this.userServiceDeleteById.deleteById(userGatewayDelete, userGatewayBuscarPorId, id);

    return ResponseEntity
      .noContent()
      .build();
  }
}

