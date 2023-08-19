package io.droidnewsnews.driver.convertersIn;

import io.droidnewsnews.core.domain.entities.UserEntity;
import io.droidnewsnews.core.domain.filters.NewsFilter;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.driver.dtos.NewsDTOIn;
import io.droidnewsnews.driver.dtos.NewsDTOOut;
import io.droidnewsnews.driver.dtos.NewsDTOUpdate;
import io.droidnewsnews.driver.dtos.NewsFilterDTO;
import io.droidnewsnews.driver.dtos.UserInDTO;
import io.droidnewsnews.driver.dtos.UserOutDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class NewsConverterInImpl implements NewsConverterIn {

  @Override
  public NewsEntity toEntity(NewsDTOIn dto) {
    var entity = new  NewsEntity();
    BeanUtils.copyProperties(dto, entity);
    return entity;
  }

  @Override
  public NewsDTOOut toDTO(NewsEntity entity) {
    return new NewsDTOOut(
      entity.getId(),
      entity.getHat(),
      entity.getTitle(),
      entity.getCaption(),
      entity.getBody(),
      entity.getNewsUsers()
    );
  }

  @Override
  public NewsEntity toEntity(NewsDTOUpdate dto) {
    var entity = new NewsEntity();
    BeanUtils.copyProperties(dto, entity);
    return entity;
  }

  @Override
  public NewsFilter toFilter(NewsFilterDTO filterDTO) {
    return new NewsFilter(
      filterDTO.id(),
      filterDTO.hat(),
      filterDTO.title(),
      filterDTO.caption(),
      filterDTO.body()
    );
  }

  @Override
  public UserEntity toEntity(UserInDTO dto) {
    var userEntity = new UserEntity();
    BeanUtils.copyProperties(dto, userEntity);
    return userEntity;
  }

  @Override
  public UserOutDTO toDTO(UserEntity entity) {
    return new UserOutDTO(
      entity.getId(),
      entity.getFullName(),
      entity.getEmail(),
      entity.getPassword()
    );
  }
}

