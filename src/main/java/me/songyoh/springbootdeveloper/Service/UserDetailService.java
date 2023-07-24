package me.songyoh.springbootdeveloper.Service;

import lombok.RequiredArgsConstructor;
import me.songyoh.springbootdeveloper.Repository.UserRepository;
import me.songyoh.springbootdeveloper.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // User 클래스가 UserDetails 인터페이스를 구현하도록 하거나, 스프링 시큐리티의 User 클래스를 사용하여 UserDetails 객체를 생성합니다.
        // 여기서는 스프링 시큐리티의 User 클래스를 사용하는 예시를 보여드리겠습니다.
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail()) // 사용자의 이름(이메일)을 설정합니다.
                .password(user.getPassword()) // 사용자의 비밀번호를 설정합니다.
                .roles("USER") // 사용자의 권한(Role)을 설정합니다. (여기서는 간단히 "USER" 권한만 설정했습니다.)
                .build();
    }
}
