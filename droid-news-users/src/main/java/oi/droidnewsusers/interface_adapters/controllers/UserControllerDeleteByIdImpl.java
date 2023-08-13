package oi.droidnewsusers.interface_adapters.controllers;

import oi.droidnewsusers.application_business_rules.use_cases.UserServiceDeleteById;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayDeleteById;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/users")
public final class UserControllerDeleteByIdImpl implements UserController.UserControllerDeleteById {

  private final UserServiceDeleteById userServiceDeleteById;

  private final UserGatewayDeleteById userGatewayDeleteById;

  public UserControllerDeleteByIdImpl(UserServiceDeleteById userServiceDeleteById,
                                      UserGatewayDeleteById userGatewayDeleteById) {
    this.userServiceDeleteById = userServiceDeleteById;
    this.userGatewayDeleteById = userGatewayDeleteById;
  }

  @Override
  public ResponseEntity<Object> deleteById(@PathVariable(name = "id") UUID id) {

    this.userServiceDeleteById.deleteById(userGatewayDeleteById, id);

    return ResponseEntity
      .noContent()
      .build();
  }
}

