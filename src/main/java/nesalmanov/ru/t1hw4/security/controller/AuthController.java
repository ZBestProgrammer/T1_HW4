package nesalmanov.ru.t1hw4.security.controller;

import nesalmanov.ru.t1hw4.security.entity.request.RefreshRequest;
import nesalmanov.ru.t1hw4.security.entity.respone.TokenResponse;
import nesalmanov.ru.t1hw4.security.jwt.JWTService;
import nesalmanov.ru.t1hw4.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refreshAccessToken(@RequestBody RefreshRequest request) {
        String refreshToken = request.getRefreshToken();

        String username = jwtService.extractUsername(refreshToken);
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);

        if (!jwtService.validateToken(refreshToken, userDetails)) {
            return ResponseEntity.status(401).body(null);
        }

        if (username.equals(userDetails.getUsername())) {
            String newAccessToken = jwtService.generateAccessToken(username);
            return ResponseEntity.ok(new TokenResponse(newAccessToken, refreshToken));
        }

        return ResponseEntity.status(403).body(null);
    }
}

