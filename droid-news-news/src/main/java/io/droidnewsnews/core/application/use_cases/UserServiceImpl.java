package io.droidnewsnews.core.application.use_cases;

import io.droidnewsnews.core.application.exceptions.http_404.NewsNotFoundException;
import io.droidnewsnews.core.application.exceptions.http_404.UserNotFoundException;
import io.droidnewsnews.core.application.ports.NewsOutputPort;
import io.droidnewsnews.core.application.ports.UserComunicationPort;
import io.droidnewsnews.core.application.ports.UserInputPort;
import io.droidnewsnews.core.application.ports.UserOutputPort;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.core.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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
  public NewsEntity subscribeUser(UUID newsId, UUID userId) {

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
  public UserEntity createUser(UserEntity userEntity, UUID newsId) {
    return null;
  }

  @Override
  public UserEntity deleteUser(UserEntity userEntity, UUID newsId) {
    return null;
  }
}

