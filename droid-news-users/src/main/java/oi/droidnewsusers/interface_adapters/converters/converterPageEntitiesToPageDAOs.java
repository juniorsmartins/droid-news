package oi.droidnewsusers.interface_adapters.converters;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;
import oi.droidnewsusers.interface_adapters.daos.UserDAO;
import org.springframework.data.domain.Page;

public interface converterPageEntitiesToPageDAOs {

  Page<UserEntity> converterPageDAOsToPageEntities(Page<UserDAO> daos);
}

