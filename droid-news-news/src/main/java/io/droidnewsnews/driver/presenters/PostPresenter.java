package io.droidnewsnews.driver.presenters;

import org.springframework.http.ResponseEntity;

public interface PostPresenter {

  ResponseEntity<Object> post(Long id, Object dto);
}

