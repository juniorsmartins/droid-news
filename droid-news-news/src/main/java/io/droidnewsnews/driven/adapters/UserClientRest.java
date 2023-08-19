package io.droidnewsnews.core.application.comunication;

import io.droidnewsnews.core.domain.entities.UserEntity;
import io.droidnewsnews.driver.dtos.UserOutDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "droid-news-users", url = "localhost:8001/api/v1/users")
public interface UserClientRest {

  @GetMapping(path = "/{id}")
  UserOutDTO buscarPorId(@PathVariable(name = "id") UUID id);

  @PostMapping
  UserEntity create(@RequestBody UserEntity userEntity);
}

