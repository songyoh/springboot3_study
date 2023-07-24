package me.songyoh.springbootdeveloper.config.jwt;

import lombok.RequiredArgsConstructor;
import me.songyoh.springbootdeveloper.entity.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TokenProvider {
    private final JwtProperties jwtProperties;

    public String generateToken(User user, Duration expiredAt){
        Date now = new Date();
        return makeToken(new Date(now.getTime() + expiredAt.toMillis()), user);
    }

    //JWT 토큰 생성 메서드
    private String makeToken(Date expiry, User user){
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // 헤더 typ:JWT
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now) // 현재시간
                .setExpiration(expiry) // 멤버 변수값
                .setSubjext(user.getEmail()) // 유저 이메일
                .claim("id", user.getId()) // 유저 ID
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey()) // 비밀값과 함께 해시값을 HS256 방식으로 암호화
                .compact();
    }

    // JWT 토큰 유효성 검증 메서드
    public boolean validToken(String token){
        try{
            Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey()) // 비밀값으로 복호화
                    .parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    // 토큰기반으로 인증 정보를 가져오는 메서드
    public Authentication getAuthentication(String token){
        Claim claim = getClaims(token);
        Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

        return new UsernamePasswordAuthenticationToken(new org.springframework.security.core.userdetails.User(claims.getSubject(),
                "",authorities), token, authorities);
    }

}
