package io.droidnewsnews.driver.adapters;

import io.droidnewsnews.core.application.ports.UserInputPort;
import io.droidnewsnews.driver.convertersIn.NewsConverterIn;
import io.droidnewsnews.driver.dtos.UserInDTO;
import io.droidnewsnews.driver.presenters.Presenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/news")
public final class NewsUsersControllerImpl implements NewsUsersController {

  @Autowired
  private NewsConverterIn converter;

  @Autowired
  private UserInputPort userInputPort;

  @Autowired
  private Presenter presenter;

  @Override
  public ResponseEntity<Object> subscribeUser(final UUID newsId, final UUID userId) {

    return Optional.of(newsId)
      .map(id -> this.userInputPort.subscribeUser(id, userId))
      .map(this.converter::toDTO)
      .map(this.presenter::put)
      .orElseThrow();
  }

  @Override
  public ResponseEntity<?> createUser(UserInDTO userInDTO, UUID newsId) {
    return null;
  }

  @Override
  public ResponseEntity<?> deleteUser(UserInDTO userInDTO, UUID newsId) {
    return null;
  }
}

