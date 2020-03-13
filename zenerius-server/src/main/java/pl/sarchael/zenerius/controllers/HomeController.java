package pl.sarchael.zenerius.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/example")
    public ResponseEntity<String> get(){
        return new ResponseEntity<>("Test API", HttpStatus.OK);
    }
}
