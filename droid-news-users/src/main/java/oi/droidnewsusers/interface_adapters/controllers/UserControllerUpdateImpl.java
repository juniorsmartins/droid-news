package oi.droidnewsusers.interface_adapters.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import oi.droidnewsusers.application_business_rules.use_cases.UserServiceUpdate;
import oi.droidnewsusers.interface_adapters.converters.ConverterDTOUpdateToEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterEntityToDTOOut;
import oi.droidnewsusers.interface_adapters.dtos.UserInDTOUpdate;
import oi.droidnewsusers.interface_adapters.dtos.UserOutDTO;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayBuscarPorId;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewayUpdate;

@RestController
@RequestMapping
public final class UserControllerUpdateImpl implements UserController.UserControllerUpdate {

  private final UserServiceUpdate userServiceUpdate;

  private final UserGatewayUpdate userGatewayUpdate;

  private final UserGatewayBuscarPorId userGatewayBuscarPorId;

  private final ConverterDTOUpdateToEntity converterDTOUpdateToEntity;

  private final ConverterEntityToDTOOut converterEntityToDTOOut;

  public UserControllerUpdateImpl(UserServiceUpdate userServiceUpdate,
                                  UserGatewayUpdate userGatewayUpdate,
                                  ConverterDTOUpdateToEntity converterDTOUpdateToEntity,
                                  UserGatewayBuscarPorId userGatewayBuscarPorId,
                                  ConverterEntityToDTOOut converterEntityToDTOOut) {
    this.userServiceUpdate = userServiceUpdate;
    this.userGatewayUpdate = userGatewayUpdate;
    this.converterDTOUpdateToEntity = converterDTOUpdateToEntity;
    this.userGatewayBuscarPorId = userGatewayBuscarPorId;
    this.converterEntityToDTOOut = converterEntityToDTOOut;
  }

  @Override
  public ResponseEntity<UserOutDTO> update(@RequestBody @Valid UserInDTOUpdate userInDTO) {

    var dto = Optional.of(userInDTO)
      .map(this.converterDTOUpdateToEntity::converterDtoUpdateToEntity)
      .map(entity -> this.userServiceUpdate.update(userGatewayUpdate, userGatewayBuscarPorId, entity))
      .map(this.converterEntityToDTOOut::converterEntityToDtoOut)
      .orElseThrow();

    return ResponseEntity
      .ok()
      .body(dto);
  }
}

