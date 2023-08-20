package io.droidnewsnews.core.application.use_cases;

import io.droidnewsnews.core.application.exceptions.http_404.NewsNotFoundException;
import io.droidnewsnews.core.application.exceptions.http_404.UserNotFoundException;
import io.droidnewsnews.core.application.ports.NewsOutputPort;
import io.droidnewsnews.core.application.ports.UserComunicationPort;
import io.droidnewsnews.core.application.ports.UserInputPort;
import io.droidnewsnews.core.application.ports.UserOutputPort;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.core.domain.entities.UserEntity;
import io.droidnewsnews.driven.daos.NewsUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserInputPort {

  @Autowired
  private NewsOutputPort newsOutputPort;

  @Autowired
  private UserComunicationPort userComunicationPort;

  @Autowired
  private UserOutputPort userOutputPort;

  @Transactional
  @Override
  public NewsEntity subscribeUser(final UUID newsId, final UUID userId) {

    var newsEntity = this.newsOutputPort.consult(newsId)
      .orElseThrow(() -> new NewsNotFoundException(newsId));

    var userFromMicroservice = this.userComunicationPort.buscarPorId(userId)
      .orElseThrow(() -> new UserNotFoundException(userId));

    var newsUserEntity = this.userOutputPort.save(userFromMicroservice.getId());

    newsEntity.addNewsUser(newsUserEntity);
    this.newsOutputPort.save(newsEntity);

    return newsEntity;
  }

  @Override
  public void unsubscribeUser(final UUID newsId, final UUID userId) {

    var newsEntity = this.newsOutputPort.consult(newsId)
      .orElseThrow(() -> new NewsNotFoundException(newsId));

    var userFromMicroservice = this.userComunicationPort.buscarPorId(userId)
      .orElseThrow(() -> new UserNotFoundException(userId));

    var newsUserEntity = this.userOutputPort.buscarPorId(userFromMicroservice.getId())
      .orElseThrow(() -> new UserNotFoundException(userId));

    newsEntity.removeNewsUser(newsUserEntity);
    this.newsOutputPort.save(newsEntity);
  }

  @Override
  public NewsEntity subscribeCreateUser(final UserEntity userEntity, final UUID newsId) {

    var newsEntity = this.newsOutputPort.consult(newsId)
      .orElseThrow(() -> new NewsNotFoundException(newsId));

    var userFromMicroservice = this.userComunicationPort.create(userEntity);

    var newsUserEntity = this.userOutputPort.save(userFromMicroservice.get().getId());

    newsEntity.addNewsUser(newsUserEntity);
    this.newsOutputPort.save(newsEntity);

    return newsEntity;
  }
}

