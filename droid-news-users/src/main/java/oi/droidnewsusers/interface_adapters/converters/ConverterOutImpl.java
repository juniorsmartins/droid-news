package oi.droidnewsusers.interface_adapters.converters;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.daos.UserDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class ConverterOutImpl implements ConverterEntityToDAO, ConverterDAOToEntity, ConverterPageEntitiesToPageDAOs {

  @Override
  public UserDAO converter(UserEntity userEntity) {
    var userDao = new UserDAO();
    BeanUtils.copyProperties(userEntity, userDao);
    return userDao;
  }

  @Override
  public UserEntity converter(UserDAO userDAO) {
    var userEntity = new UserEntity();
    BeanUtils.copyProperties(userDAO, userEntity);
    return userEntity;
  }

  @Override
  public Page<UserEntity> converterPage(Page<UserDAO> daos) {
    List<UserEntity> entities = new ArrayList<>();

    daos.forEach(dao -> {
      var entity = new UserEntity();
      BeanUtils.copyProperties(dao, entity);
      entities.add(entity);
    });

    return new PageImpl<>(entities, PageRequest.of(daos.getNumber(), daos.getSize(), daos.getSort()), daos.getTotalElements());
  }
}

