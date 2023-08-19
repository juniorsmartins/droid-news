package io.droidnewsnews.driven.convertersOut;

import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.core.domain.entities.NewsUserEntity;
import io.droidnewsnews.core.domain.entities.UserEntity;
import io.droidnewsnews.driven.daos.NewsDAO;
import io.droidnewsnews.driven.daos.NewsUserDAO;
import io.droidnewsnews.driver.dtos.UserOutDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class NewsConverterOutImpl implements NewsConverterOut {

  @Override
  public NewsDAO toDAO(NewsEntity entity) {
    var newsDAO = new NewsDAO();
    newsDAO.setId(entity.getId());
    newsDAO.setHat(entity.getHat());
    newsDAO.setTitle(entity.getTitle());
    newsDAO.setCaption(entity.getCaption());
    newsDAO.setBody(entity.getBody());
    newsDAO.setNewsUsers(entity.getNewsUsers().stream().map(this::toDAO).toList());
    return newsDAO;
  }

  @Override
  public NewsEntity toEntity(NewsDAO newsDAO) {
    var entity = new NewsEntity();
    entity.setId(newsDAO.getId());
    entity.setHat(newsDAO.getHat());
    entity.setTitle(newsDAO.getTitle());
    entity.setCaption(newsDAO.getCaption());
    entity.setBody(newsDAO.getBody());
    entity.setNewsUsers(newsDAO.getNewsUsers().stream().map(this::toEntity).toList());
    return entity;
  }

  @Override
  public UserEntity toEntity(UserOutDTO userOutDTO) {
    var entity = new UserEntity();
    BeanUtils.copyProperties(userOutDTO, entity);
    return entity;
  }

  @Override
  public NewsUserDAO toDAO(UserEntity entity) {
    var newsUserDAO = new NewsUserDAO();
    newsUserDAO.setUserId(entity.getId());
    return newsUserDAO;
  }

  @Override
  public NewsUserEntity toEntity(NewsUserDAO dao) {
    var entity = new NewsUserEntity();
    BeanUtils.copyProperties(dao, entity);
    return entity;
  }

  @Override
  public NewsUserDAO toDAO(NewsUserEntity entity) {
    var dao = new NewsUserDAO();
    BeanUtils.copyProperties(entity, dao);
    return dao;
  }
}

