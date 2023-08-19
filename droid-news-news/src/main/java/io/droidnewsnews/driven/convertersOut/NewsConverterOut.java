package io.droidnewsnews.driven.convertersOut;

import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.core.domain.entities.NewsUserEntity;
import io.droidnewsnews.core.domain.entities.UserEntity;
import io.droidnewsnews.driven.daos.NewsDAO;
import io.droidnewsnews.driven.daos.NewsUserDAO;
import io.droidnewsnews.driver.dtos.UserInDTO;
import io.droidnewsnews.driver.dtos.UserOutDTO;

public interface NewsConverterOut {

  NewsDAO toDAO(NewsEntity newsEntity);

  NewsEntity toEntity(NewsDAO newsDAO);

  UserEntity toEntity(UserOutDTO userOutDTO);

  NewsUserEntity toEntity(NewsUserDAO newsUserDAO);

  NewsUserDAO toDAO(NewsUserEntity entity);

  UserInDTO toInDTO(UserEntity entity);
}

