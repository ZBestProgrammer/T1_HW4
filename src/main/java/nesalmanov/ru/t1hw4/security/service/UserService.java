package nesalmanov.ru.t1hw4.security.service;

import nesalmanov.ru.t1hw4.security.entity.User;
import nesalmanov.ru.t1hw4.security.entity.request.UserLoginRequest;
import nesalmanov.ru.t1hw4.security.entity.request.UserRegisterRequest;
import nesalmanov.ru.t1hw4.security.jwt.JWTService;
import nesalmanov.ru.t1hw4.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public User register(UserRegisterRequest userRegisterRequest) {
        User newUser = new User();
        newUser.setUsername(userRegisterRequest.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(userRegisterRequest.getPassword()));
        newUser.setEmail(userRegisterRequest.getEmail());
        newUser.setRole(userRegisterRequest.getRole());

        User addUser = userRepository.save(newUser);

        return addUser;
    }

    public String verify(UserLoginRequest userLoginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginRequest.getUsername(), userLoginRequest.getPassword())
        );

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userLoginRequest);
        }
        return "Bad credentials";
    }
}
