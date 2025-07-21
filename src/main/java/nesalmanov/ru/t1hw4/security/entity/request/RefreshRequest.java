package nesalmanov.ru.t1hw4.security.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RefreshRequest {

    private String refreshToken;

}
