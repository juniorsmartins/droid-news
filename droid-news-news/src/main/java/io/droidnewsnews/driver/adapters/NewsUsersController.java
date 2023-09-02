package io.droidnewsnews.driver.adapters;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.droidnewsnews.driver.dtos.UserInDTO;
import jakarta.validation.Valid;

public interface NewsUsersController {

  @PutMapping(path = "/{newsId}/subscribe-user/{userId}")
  ResponseEntity<Object> subscribeUser(@PathVariable(name = "newsId") final UUID newsId,
                                       @PathVariable(name = "userId") final UUID userId);

  @DeleteMapping(path = "/{newsId}/unsubscribe-user/{userId}")
  ResponseEntity<Object> unsubscribeUser(@PathVariable(name = "newsId") final UUID newsId,
                                         @PathVariable(name = "userId") final UUID userId);

  @PutMapping(path = "/{newsId}/subscribe-user")
  ResponseEntity<?> subscribeCreateUser(@RequestBody @Valid final UserInDTO userInDTO,
                                        @PathVariable(name = "newsId") final UUID newsId);
}

