package com.murali;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping
    private ResponseEntity<String> health() {
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
