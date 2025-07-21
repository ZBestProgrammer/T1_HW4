package nesalmanov.ru.t1hw4.security.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import nesalmanov.ru.t1hw4.security.entity.Role;

@AllArgsConstructor
@Getter
@Setter
public class UserRegisterRequest {

    private String username;
    private String email;
    private String password;
    private Role role;

}