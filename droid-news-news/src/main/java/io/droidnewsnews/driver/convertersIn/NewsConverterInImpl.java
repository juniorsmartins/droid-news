package io.droidnewsnews.driver.convertersIn;

import io.droidnewsnews.core.domain.NewsFilter;
import io.droidnewsnews.core.domain.entities.NewsEntity;
import io.droidnewsnews.driver.dtos.NewsDTOIn;
import io.droidnewsnews.driver.dtos.NewsDTOOut;
import io.droidnewsnews.driver.dtos.NewsDTOUpdate;
import io.droidnewsnews.driver.dtos.NewsFilterDTO;
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
      entity.getBody()
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
}

