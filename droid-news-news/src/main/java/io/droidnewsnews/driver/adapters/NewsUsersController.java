package io.droidnewsnews.driver.adapters;

import io.droidnewsnews.driver.dtos.UserInDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface NewsUsersController {

  @PutMapping(path = "/{newsId}/subscribe-user/{userId}")
  ResponseEntity<?> subscribeUser(@PathVariable(name = "newsId") final UUID newsId,
                                  @PathVariable(name = "userId") final UUID userId);

  @PostMapping(path = "/{newsId}")
  ResponseEntity<?> createUser(@RequestBody @Valid final UserInDTO userInDTO,
                               @PathVariable(name = "newsId") final UUID newsId);

  @DeleteMapping(path = "/{newsId}")
  ResponseEntity<?> deleteUser(@RequestBody @Valid final UserInDTO userInDTO,
                               @PathVariable(name = "newsId") final UUID newsId);
}

