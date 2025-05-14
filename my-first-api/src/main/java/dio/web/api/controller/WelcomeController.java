package dio.web.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Define a classe como um controlador
@RestController
public class WelcomeController {

    @GetMapping()
    public String welcome() {
        return "Welcome to my Springboot web app API ^w^.";
    }

}
