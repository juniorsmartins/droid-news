package oi.droidnewsusers.interface_adapters.converters;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.daos.UserDAO;

public interface converterEntityToDAO {

  UserDAO converterEntityToDAO(UserEntity userEntity);
}

