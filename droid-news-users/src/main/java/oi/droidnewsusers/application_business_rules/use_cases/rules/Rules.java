package oi.droidnewsusers.application_business_rules.use_cases.rules;

import oi.droidnewsusers.enterprise_business_rules.entities.UserEntity;

public interface Rules {

  void executar(UserEntity entity);
}

