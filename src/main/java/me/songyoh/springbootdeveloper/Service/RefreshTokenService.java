package me.songyoh.springbootdeveloper.Service;

import lombok.RequiredArgsConstructor;
import me.songyoh.springbootdeveloper.Repository.RefreshTokenRepository;
import me.songyoh.springbootdeveloper.entity.RefreshToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}
