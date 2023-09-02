package io.droidnewsnews.driver.adapters;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.droidnewsnews.core.application.ports.UserInputPort;
import io.droidnewsnews.driver.convertersIn.NewsConverterIn;
import io.droidnewsnews.driver.dtos.UserInDTO;
import io.droidnewsnews.driver.presenters.Presenter;

@RestController
@RequestMapping
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
  public ResponseEntity<Object> unsubscribeUser(final UUID newsId, final UUID userId) {

    this.userInputPort.unsubscribeUser(newsId, userId);
    return this.presenter.delete();
  }

  @Override
  public ResponseEntity<Object> subscribeCreateUser(final UserInDTO userInDTO, final UUID newsId) {

    return Optional.of(userInDTO)
      .map(this.converter::toEntity)
      .map(entity -> this.userInputPort.subscribeCreateUser(entity, newsId))
      .map(this.converter::toDTO)
      .map(this.presenter::put)
      .orElseThrow();
  }
}

