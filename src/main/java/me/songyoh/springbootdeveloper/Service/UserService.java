package me.songyoh.springbootdeveloper.Service;

import lombok.RequiredArgsConstructor;
import me.songyoh.springbootdeveloper.DTO.AddUserRequest;
import me.songyoh.springbootdeveloper.Repository.UserRepository;
import me.songyoh.springbootdeveloper.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                // 패스워드 암호화
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }
}