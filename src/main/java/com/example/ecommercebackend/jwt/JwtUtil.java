package com.example.ecommercebackend.jwt;

import com.example.ecommercebackend.entity.UserEntity;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String secret = "sifremele123!";

    private final long jwtExpirationMs = 1000 * 60 * 60;

    public String generateToken(UserEntity userEntity) {
        return Jwts.builder()
                .setSubject(userEntity.getEmail()) // Token’ın ana konusu/kime ait olduğu (genelde email/id)
                .claim("role", userEntity.getRole().name())//role eklendi
                .setIssuedAt(new Date()) // Oluşturulma zamanı
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs)) // Geçerlilik sonu
                .signWith(SignatureAlgorithm.HS256, secret) // Hangi algoritma + gizli anahtar ile imzalanacak
                .compact(); // Token’ı string olarak hazırla
    }

    public String extractEmail(String token) {
        return Jwts.parser()
                .setSigningKey(secret) // Hangi anahtarla doğrulayacağını söyler
                .parseClaimsJws(token) // Token’ı çözer (parçalar, imzayı kontrol eder)
                .getBody()             // İçinde kullanıcıya dair bilgiler olan payload’u alır
                .getSubject();         // Subject alanını (yani email) çeker
    }
    public String extractRole(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims.get("role", String.class);
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true; // Hatasız parse edilirse, token geçerli demektir
        } catch (JwtException | IllegalArgumentException e) {
            return false; // Hata olursa (süresi dolmuş, imzası bozuk, token formatı yanlış vs.) geçerli değildir
        }
    }

}
