package oi.droidnewsusers.interface_adapters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/users")
public final class UserControllerQuebrarImpl implements UserController.UserControllerQuebrar {

    @Autowired
    private ApplicationContext context;

    @Override
    public ResponseEntity<Object> quebrar() {

        if (true) {
            ((ConfigurableApplicationContext)context).close();
            // throw new UnsupportedOperationException("Unimplemented method 'crash'");
            return null;
        }

        return ResponseEntity.ok().build();
    }
    
}

