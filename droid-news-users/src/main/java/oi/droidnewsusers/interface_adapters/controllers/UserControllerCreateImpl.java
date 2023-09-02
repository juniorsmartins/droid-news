package oi.droidnewsusers.interface_adapters.controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import oi.droidnewsusers.application_business_rules.use_cases.UserServiceCreate;
import oi.droidnewsusers.interface_adapters.converters.ConverterDTOInToEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterEntityToDTOOut;
import oi.droidnewsusers.interface_adapters.dtos.UserInDTO;
import oi.droidnewsusers.interface_adapters.dtos.UserOutDTO;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewaySave;

@RestController
@RequestMapping
public final class UserControllerCreateImpl implements UserController.UserControllerCreate {

  private final UserServiceCreate userServiceCreate;

  private final UserGatewaySave userGatewaySave;

  private final ConverterDTOInToEntity converterDTOInToEntity;

  private final ConverterEntityToDTOOut converterEntityToDTOOut;

  public UserControllerCreateImpl(UserServiceCreate userServiceCreate,
                                  UserGatewaySave userGatewaySave,
                                  ConverterDTOInToEntity converterDTOInToEntity,
                                  ConverterEntityToDTOOut converterEntityToDTOOut) {
    this.userServiceCreate = userServiceCreate;
    this.userGatewaySave = userGatewaySave;
    this.converterDTOInToEntity = converterDTOInToEntity;
    this.converterEntityToDTOOut = converterEntityToDTOOut;
  }

  @Override
  public ResponseEntity<UserOutDTO> create(@RequestBody @Valid UserInDTO userInDTO) {

    var dto = Optional.of(userInDTO)
      .map(this.converterDTOInToEntity::converterDtoInToEntity)
      .map(entity -> this.userServiceCreate.create(userGatewaySave, entity))
      .map(this.converterEntityToDTOOut::converterEntityToDtoOut)
      .orElseThrow();

    return ResponseEntity
      .created(URI.create("/api/v1/clientes/" + dto.getId()))
      .body(dto);
  }
}

