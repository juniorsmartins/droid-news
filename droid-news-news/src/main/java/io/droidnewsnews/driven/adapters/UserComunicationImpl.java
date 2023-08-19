package io.droidnewsnews.driven.adapters;

import io.droidnewsnews.core.application.ports.NewsOutputPort;
import io.droidnewsnews.core.application.ports.UserComunicationPort;
import io.droidnewsnews.core.domain.entities.UserEntity;
import io.droidnewsnews.driven.convertersOut.NewsConverterOut;
import io.droidnewsnews.driven.daos.NewsUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserComunicationImpl implements UserComunicationPort {

  @Autowired
  private NewsConverterOut converter;

  @Autowired
  private NewsOutputPort newsOutputPort;

  @Autowired
  private UserClientRest userClientRest;

  @Override
  public Optional<UserEntity> buscarPorId(final UUID userId) {

    return Optional.of(userId)
      .map(this.userClientRest::buscarPorId)
      .map(this.converter::toEntity);
  }

//  @Override
//  public Optional<UserEntity> subscribeUser(UserEntity userEntity, UUID newsId) {
//
//    var newsDatabase = this.newsOutputPort.consult(newsId);
//
//    if (newsDatabase.isPresent()) {
//      var userDoutroMicroservice = this.userClientRest.buscarPorId(userEntity.getId());
//
//      var newsUserDAO = new NewsUserDAO();
//      newsUserDAO.setUserId(userDoutroMicroservice.getId());
//
//      var newsEntity = newsDatabase.get();
//      newsEntity.addNewsUser(newsUserDAO);
//      this.newsOutputPort.save(newsEntity);
//      return Optional.of(userDoutroMicroservice);
//    }
//    return Optional.empty();
//  }
//
//  @Override
//  public Optional<UserEntity> createUser(UserEntity userEntity, UUID newsId) {
//
//    var newsDatabase = this.newsOutputPort.consult(newsId);
//
//    if (newsDatabase.isPresent()) {
//      var userDoutroMicroservice = this.userClientRest.create(userEntity);
//
//      var newsUserDAO = new NewsUserDAO();
//      newsUserDAO.setUserId(userDoutroMicroservice.getId());
//
//      var newsEntity = newsDatabase.get();
//      newsEntity.addNewsUser(newsUserDAO);
//      this.newsOutputPort.save(newsEntity);
//      return Optional.of(userDoutroMicroservice);
//    }
//    return Optional.empty();
//  }
//
//  @Override
//  public Optional<UserEntity> deleteUser(UserEntity userEntity, UUID newsId) {
//
//    var newsDatabase = this.newsOutputPort.consult(newsId);
//
//    if (newsDatabase.isPresent()) {
//      var userDoutroMicroservice = this.userClientRest.buscarPorId(userEntity.getId());
//
//      var newsUserDAO = new NewsUserDAO();
//      newsUserDAO.setUserId(userDoutroMicroservice.getId());
//
//      var newsEntity = newsDatabase.get();
//      newsEntity.removeNewsUser(newsUserDAO);
//      this.newsOutputPort.save(newsEntity);
//      return Optional.of(userDoutroMicroservice);
//    }
//    return Optional.empty();
//  }
}
