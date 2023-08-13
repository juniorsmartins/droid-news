package oi.droidnewsusers.interface_adapters.dtos;

import java.util.UUID;

public interface UserInDTO {

  void setId(UUID id);

  UUID getId();

  void setFullName(String fullName);

  String getFullName();

  void setEmail(String email);

  String getEmail();

  void setPassword(String password);

  String getPassword();
}

