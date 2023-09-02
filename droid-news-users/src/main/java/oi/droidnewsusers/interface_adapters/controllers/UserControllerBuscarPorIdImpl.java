package oi.droidnewsusers.interface_adapters.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oi.droidnewsusers.application_business_rules.use_cases.UserServiceBuscarPorId;
import oi.droidnewsusers.interface_adapters.converters.ConverterEntityToDTOOut;
import oi.droidnewsusers.interface_adapters.dtos.UserOutDTO;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayBuscarPorId;

@RestController
@RequestMapping
public final class UserControllerBuscarPorIdImpl implements UserController.UserControllerBuscarPorId {

  private final UserServiceBuscarPorId userServiceBuscarPorId;

  private final UserGatewayBuscarPorId userGatewayBuscarPorId;

  private final ConverterEntityToDTOOut converterEntityToDTOOut;

  public UserControllerBuscarPorIdImpl(UserServiceBuscarPorId userServiceBuscarPorId,
                                       UserGatewayBuscarPorId userGatewayBuscarPorId,
                                       ConverterEntityToDTOOut converterEntityToDTOOut) {
    this.userServiceBuscarPorId = userServiceBuscarPorId;
    this.userGatewayBuscarPorId = userGatewayBuscarPorId;
    this.converterEntityToDTOOut = converterEntityToDTOOut;
  }

  @Override
  public ResponseEntity<UserOutDTO> buscarPorId(@PathVariable(name = "id") final UUID id) {

    var dto = Optional.of(this.userServiceBuscarPorId.buscarPorId(userGatewayBuscarPorId, id))
      .map(this.converterEntityToDTOOut::converterEntityToDtoOut)
      .orElseThrow();

    return ResponseEntity
      .ok()
      .body(dto);
  }
}

