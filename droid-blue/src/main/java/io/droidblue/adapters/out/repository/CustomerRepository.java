package io.droidblue.adapters.out.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.droidblue.adapters.out.repository.entity.CustomerEntity;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> { }

