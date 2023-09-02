package io.droidnewsnews.driven.adapters;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.droidnewsnews.driver.dtos.UserInDTO;
import io.droidnewsnews.driver.dtos.UserOutDTO;

@FeignClient(name = "users")
public interface UserClientRest {

  @GetMapping(path = "/api/v1/users/{id}")
  UserOutDTO buscarPorId(@PathVariable(name = "id") UUID id);

  @PostMapping(path = "/api/v1/users")
  UserOutDTO create(@RequestBody UserInDTO userInDTO);
}

