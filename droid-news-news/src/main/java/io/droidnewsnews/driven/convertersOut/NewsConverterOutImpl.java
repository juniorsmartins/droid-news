package io.droidnewsnews.driven.convertersOut;

import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.driven.daos.NewsDAO;
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
    return newsDAO;
  }

  @Override
  public NewsEntity toEntity(NewsDAO newsDAO) {
    var entity = new NewsEntity();
    BeanUtils.copyProperties(newsDAO, entity);
    return entity;
  }
}

