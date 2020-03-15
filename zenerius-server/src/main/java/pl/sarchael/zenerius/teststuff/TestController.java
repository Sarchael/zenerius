package pl.sarchael.zenerius.teststuff;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/example")
    public ResponseEntity<String> get(){
        return new ResponseEntity<>("Test API", HttpStatus.OK);
    }
}
