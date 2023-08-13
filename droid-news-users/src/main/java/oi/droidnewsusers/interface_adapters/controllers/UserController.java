package oi.droidnewsusers.interface_adapters.controllers;

import oi.droidnewsusers.interface_adapters.dtos.UserInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

public interface UserController {

  interface UserControllerSalvar {
    @PostMapping
    ResponseEntity<Object> salvar(UserInDTO userInDTO);
  }

  interface UserControllerBuscarPorId {
    @GetMapping(path = "/{id}")
    ResponseEntity<Object> buscarPorId(UUID id);
  }

  interface UserControllerListar {
    @GetMapping
    ResponseEntity<List<Object>> listar();
  }

  interface UserControllerDeleteById {
    @DeleteMapping(path = "/{id}")
    ResponseEntity<Object> deleteById(UUID id);
  }
}

