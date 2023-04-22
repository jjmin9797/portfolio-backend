package port.folio.portfolio_backend.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;


import java.util.Base64;
import java.util.Date;

public class JwtTokenUtil {
    private static final long JWT_EXPIRATION_MS = 86400000L; // 24 hours
    private static final String JWT_SECRET_KEY = "asdkvjkljsalkdjsa2lkdjs4alkdjvklndl5sadlksjclkajsdasd";


    public static String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION_MS);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(JWT_SECRET_KEY.getBytes()))
                .compact();
    }
    public static String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }




    public static boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET_KEY).parseClaimsJws(authToken);
            return true;
        } catch (IllegalStateException ex) {
            // Signature is invalid
            return false;
        }
    }
}
