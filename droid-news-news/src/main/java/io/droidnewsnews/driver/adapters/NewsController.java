package io.droidnewsnews.driver.adapters;

import io.droidnewsnews.driver.dtos.NewsDTOIn;
import io.droidnewsnews.driver.dtos.NewsDTOUpdate;
import io.droidnewsnews.driver.dtos.NewsFiltroDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

public interface NewsController {

  @PostMapping
  ResponseEntity<Object> create(NewsDTOIn newsDTOIn);

  @PutMapping
  ResponseEntity<Object> update(NewsDTOUpdate newsDTOUpdate);

  @GetMapping
  ResponseEntity<Object> pesquisar(NewsFiltroDTO filtro, Pageable paginacao);

  @DeleteMapping(path = "/{id}")
  ResponseEntity<Object> deletarPorId(UUID id);
}

