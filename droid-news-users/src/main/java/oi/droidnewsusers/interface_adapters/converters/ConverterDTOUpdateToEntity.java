package oi.droidnewsusers.interface_adapters.converters;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.dtos.UserInDTO;
import oi.droidnewsusers.interface_adapters.dtos.UserInDTOUpdate;

public interface ConverterDTOUpdateToEntity {

  UserEntity converterDtoUpdateToEntity(UserInDTOUpdate userInDTO);
}

