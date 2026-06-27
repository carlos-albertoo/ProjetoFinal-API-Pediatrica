package br.com.clinica.pediatrica.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;
import br.com.clinica.pediatrica.models.entities.Usuario;

@Service
public class TokenService {
    private String secret = "12345678"; // Em um projeto real, use uma chave forte e secreta!

    public String gerarToken(Usuario usuario) {
        return JWT.create()
                .withIssuer("clinica-api")
                .withSubject(usuario.getEmail())
                .sign(Algorithm.HMAC256(secret));
    }

    public String getSubject(String tokenJWT) {
        return JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("clinica-api")
                .build()
                .verify(tokenJWT)
                .getSubject();
    }
}
