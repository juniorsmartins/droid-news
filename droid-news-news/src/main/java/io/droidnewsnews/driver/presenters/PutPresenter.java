package io.droidnewsnews.driver.presenters;

import org.springframework.http.ResponseEntity;

public interface PutPresenter {

  ResponseEntity<Object> put(Object objeto);
}

