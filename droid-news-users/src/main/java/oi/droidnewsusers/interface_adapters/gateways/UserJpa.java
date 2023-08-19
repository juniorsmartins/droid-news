package oi.droidnewsusers.interface_adapters.gateways;

import oi.droidnewsusers.interface_adapters.daos.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpa extends JpaRepository<UserDAO, UUID> {

  Optional<UserDAO> findByEmail(String email);
}

