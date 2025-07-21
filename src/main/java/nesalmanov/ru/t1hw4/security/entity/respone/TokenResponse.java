package nesalmanov.ru.t1hw4.security.entity.respone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TokenResponse {

    private String accessToken;
    private String refreshToken;

}
