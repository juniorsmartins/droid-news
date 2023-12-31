package oi.droidnewsusers.interface_adapters.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oi.droidnewsusers.application_business_rules.use_cases.UserServiceListar;
import oi.droidnewsusers.interface_adapters.converters.ConverterEntityToDTOOut;
import oi.droidnewsusers.interface_adapters.dtos.UserOutDTO;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayListar;

@RestController
@RequestMapping
public final class UserControllerListarImpl implements UserController.UserControllerListar {

  private final UserServiceListar userServiceListar;

  private final UserGatewayListar userGatewayListar;

  private final ConverterEntityToDTOOut converterEntityToDTOOut;

  public UserControllerListarImpl(UserServiceListar userServiceListar,
                                  UserGatewayListar userGatewayListar,
                                  ConverterEntityToDTOOut converterEntityToDTOOut) {
    this.userServiceListar = userServiceListar;
    this.userGatewayListar = userGatewayListar;
    this.converterEntityToDTOOut = converterEntityToDTOOut;
  }

  @Override
  public ResponseEntity<List<UserOutDTO>> listar() {

    var dtos = this.userServiceListar.listar(userGatewayListar)
      .stream()
      .map(this.converterEntityToDTOOut::converterEntityToDtoOut)
      .toList();

    return ResponseEntity
      .ok()
      .body(dtos);
  }
}

