package com.willjager.api_gateway.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    private String jwtSecret = "VGhpcyBpcyB0aGUgSldUIHNlY3JldCBrZXkgZm9yIGltcGxlbWVudGluZyBqd3QgdG9rZW4gc3lzdGVtIGluIGF1dGggc2VydmljZQ==";
    private Long jwtExpirationInMs = 604800L;

    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
