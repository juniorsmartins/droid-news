package io.droidnewsnews.driver.adapters;

import io.droidnewsnews.core.application.ports.NewsInputPort;
import io.droidnewsnews.driver.convertersIn.NewsConverterIn;
import io.droidnewsnews.driver.dtos.NewsDTOIn;
import io.droidnewsnews.driver.dtos.NewsDTOUpdate;
import io.droidnewsnews.driver.dtos.NewsFilterDTO;
import io.droidnewsnews.driver.presenters.Presenter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/news")
public final class NewsControllerImpl implements NewsController {

  @Autowired
  private NewsConverterIn converter;

  @Autowired
  private NewsInputPort inputPort;

  @Autowired
  private Presenter presenter;

  @Override
  public ResponseEntity<Object> create(@RequestBody @Valid final NewsDTOIn newsDTOIn) {

    return Optional.of(newsDTOIn)
      .map(this.converter::toEntity)
      .map(this.inputPort::create)
      .map(this.converter::toDTO)
      .map(dto -> this.presenter.post(dto.id(), dto))
      .orElseThrow();
  }

  @Override
  public ResponseEntity<Object> update(NewsDTOUpdate newsDTOUpdate) {
    return null;
  }

  @Override
  public ResponseEntity<Object> search(NewsFilterDTO filter, Pageable pagination) {
    return null;
  }

  @Override
  public ResponseEntity<Object> deletarPorId(UUID id) {
    return null;
  }
}

