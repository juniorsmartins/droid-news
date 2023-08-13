package oi.droidnewsusers.interface_adapters.controllers;

import jakarta.validation.Valid;
import oi.droidnewsusers.application_business_rules.use_cases.UserServiceSalvar;
import oi.droidnewsusers.interface_adapters.converters.ConverterDTOInToEntity;
import oi.droidnewsusers.interface_adapters.converters.ConverterEntityToDTOOut;
import oi.droidnewsusers.interface_adapters.dtos.UserInDTO;
import oi.droidnewsusers.interface_adapters.gateways.UserGatewaySalvar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/users")
public final class UserControllerSalvarImpl implements UserController.UserControllerSalvar {

  private final UserServiceSalvar userServiceSalvar;

  private final UserGatewaySalvar userGatewaySalvar;

  private final ConverterDTOInToEntity converterDTOInToEntity;

  private final ConverterEntityToDTOOut converterEntityToDTOOut;

  public UserControllerSalvarImpl(UserServiceSalvar userServiceSalvar,
                                  UserGatewaySalvar userGatewaySalvar,
                                  ConverterDTOInToEntity converterDTOInToEntity,
                                  ConverterEntityToDTOOut converterEntityToDTOOut) {
    this.userServiceSalvar = userServiceSalvar;
    this.userGatewaySalvar = userGatewaySalvar;
    this.converterDTOInToEntity = converterDTOInToEntity;
    this.converterEntityToDTOOut = converterEntityToDTOOut;
  }

  @Override
  public ResponseEntity<Object> salvar(@RequestBody @Valid UserInDTO userInDTO) {

    var dto = Optional.of(userInDTO)
      .map(this.converterDTOInToEntity::converterIn)
      .map(entity -> this.userServiceSalvar.salvar(userGatewaySalvar, entity))
      .map(this.converterEntityToDTOOut::converterIn)
      .orElseThrow();

    return ResponseEntity
      .created(URI.create("/api/v1/clientes/" + dto.getId()))
      .body(dto);
  }
}

