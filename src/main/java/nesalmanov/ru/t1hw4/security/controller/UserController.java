package nesalmanov.ru.t1hw4.security.controller;


import nesalmanov.ru.t1hw4.security.entity.User;
import nesalmanov.ru.t1hw4.security.entity.request.UserLoginRequest;
import nesalmanov.ru.t1hw4.security.entity.request.UserRegisterRequest;
import nesalmanov.ru.t1hw4.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        return userService.register(userRegisterRequest);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserLoginRequest userLoginRequest) {
        return userService.verify(userLoginRequest);
    }

}
