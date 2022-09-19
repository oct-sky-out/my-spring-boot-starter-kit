package com.nhnacademy.projectbulk.security.service;


import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 로그인 시 사용자 정보를 가져오는 UserDetailService입니다.
 *
 * @author 김민수
 * @since 1.0
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");

        return new User("example-user-name", "",
            Collections.singletonList(authority));
    }
}
