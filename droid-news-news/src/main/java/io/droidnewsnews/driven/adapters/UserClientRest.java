package io.droidnewsnews.driven.adapters;

import io.droidnewsnews.driver.dtos.UserInDTO;
import io.droidnewsnews.driver.dtos.UserOutDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "users", url = "${droid.news.users.url}/api/v1/users")
public interface UserClientRest {

  @GetMapping(path = "/{id}")
  UserOutDTO buscarPorId(@PathVariable(name = "id") UUID id);

  @PostMapping
  UserOutDTO create(@RequestBody UserInDTO userInDTO);
}

