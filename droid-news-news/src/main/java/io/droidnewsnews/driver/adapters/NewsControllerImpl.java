package io.droidnewsnews.driver.adapters;

import io.droidnewsnews.driver.dtos.NewsDTOIn;
import io.droidnewsnews.driver.dtos.NewsDTOUpdate;
import io.droidnewsnews.driver.dtos.NewsFiltroDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public final class NewsControllerImpl implements NewsController {

  @Override
  public ResponseEntity<Object> create(NewsDTOIn newsDTOIn) {
    return null;
  }

  @Override
  public ResponseEntity<Object> update(NewsDTOUpdate newsDTOUpdate) {
    return null;
  }

  @Override
  public ResponseEntity<Object> pesquisar(NewsFiltroDTO filtro, Pageable paginacao) {
    return null;
  }

  @Override
  public ResponseEntity<Object> deletarPorId(UUID id) {
    return null;
  }
}

