package io.droidnewsnews.driver.presenters;

import org.springframework.http.ResponseEntity;

public interface GetPresenter {

  ResponseEntity<Object> get(Object objeto);
}

