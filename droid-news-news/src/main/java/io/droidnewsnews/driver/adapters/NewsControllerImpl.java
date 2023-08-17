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
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
  public ResponseEntity<Object> update(@RequestBody @Valid NewsDTOUpdate newsDTOUpdate) {

    return Optional.of(newsDTOUpdate)
      .map(this.converter::toEntity)
      .map(this.inputPort::update)
      .map(this.converter::toDTO)
      .map(this.presenter::put)
      .orElseThrow();
  }

  @Override
  public ResponseEntity<Object> search(@Valid final NewsFilterDTO filterDTO,
    @PageableDefault(sort = "title", direction = Sort.Direction.ASC, page = 0, size = 10) final Pageable pagination) {

    return Optional.of(filterDTO)
      .map(this.converter::toFilter)
      .map(filter -> this.inputPort.search(filter, pagination))
      .map(this.converter::toPageDTOOut)
      .map(this.presenter::get)
      .orElseThrow();
  }

  @Override
  public ResponseEntity<Object> deletarPorId(final UUID id) {

    this.inputPort.delete(id);
    return this.presenter.delete();
  }
}

