package oi.droidnewsusers.interface_adapters.controllers;

import oi.droidnewsusers.interface_adapters.dtos.UserInDTO;
import oi.droidnewsusers.interface_adapters.dtos.UserInDTOUpdate;
import oi.droidnewsusers.interface_adapters.dtos.UserOutDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.UUID;

public interface UserController {

  interface UserControllerCreate {
    @PostMapping
    ResponseEntity<UserOutDTO> create(UserInDTO userInDTO);
  }

  interface UserControllerUpdate {
    @PutMapping
    ResponseEntity<UserOutDTO> update(UserInDTOUpdate userInDTO);
  }

  interface UserControllerBuscarPorId {
    @GetMapping(path = "/{id}")
    ResponseEntity<UserOutDTO> buscarPorId(UUID id);
  }

  interface UserControllerListar {
    @GetMapping
    ResponseEntity<List<UserOutDTO>> listar();
  }

  interface UserControllerDeleteById {
    @DeleteMapping(path = "/{id}")
    ResponseEntity<Object> deleteById(UUID id);
  }

  interface UserControllerQuebrar {
    @GetMapping(path = "/quebrar")
    ResponseEntity<Object> quebrar();
  }
}

