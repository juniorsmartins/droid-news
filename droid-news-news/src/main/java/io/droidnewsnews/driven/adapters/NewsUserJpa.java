package io.droidnewsnews.driven.adapters;

import io.droidnewsnews.driven.daos.NewsUserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NewsUserJpa extends JpaRepository<NewsUserDAO, UUID> {

  Optional<NewsUserDAO> findByUserId(UUID userId);
}

