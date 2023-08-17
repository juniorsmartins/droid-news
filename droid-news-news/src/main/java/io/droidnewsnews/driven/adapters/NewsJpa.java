package io.droidnewsnews.driven.adapters;

import io.droidnewsnews.driven.daos.NewsDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface NewsJpa extends JpaRepository<NewsDAO, UUID>, JpaSpecificationExecutor<NewsDAO> { }

