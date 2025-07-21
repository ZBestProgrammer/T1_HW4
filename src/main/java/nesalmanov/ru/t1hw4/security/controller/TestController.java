package nesalmanov.ru.t1hw4.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello, admin";
    }

    @GetMapping("/premium_user")
    public String helloPremiumUser() {
        return "Hello, premium user";
    }

    @GetMapping("/guest")
    public String helloGuest() {
        return "Hello, guest";
    }

}
