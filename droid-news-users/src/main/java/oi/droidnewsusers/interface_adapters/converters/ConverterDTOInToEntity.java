package oi.droidnewsusers.interface_adapters.converters;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.dtos.UserInDTO;

public interface ConverterDTOInToEntity {

  UserEntity converterIn(UserInDTO userInDTO);
}

