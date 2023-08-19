package io.droidnewsnews.driver.presenters;

import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface Presenter {

  ResponseEntity<Object> post(UUID id, Object dto);

  ResponseEntity<Object> put(Object objeto);

  ResponseEntity<Object> get(Object objeto);

  ResponseEntity<Object> delete();
}

