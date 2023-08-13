package oi.droidnewsusers.interface_adapters.converters;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.dtos.UserOutDTO;

public interface ConverterEntityToDTOOut {

  UserOutDTO converterIn(UserEntity userEntity);
}

