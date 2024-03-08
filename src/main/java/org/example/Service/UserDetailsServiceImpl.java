package org.example.Service;

import org.example.Entity.Roles;
import org.example.Entity.User;
import org.example.Repository.UserRepository;
import org.example.config.WebSecurityConfigDB;
import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException("UserName Not Fount");
        }
            return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).roles(String.valueOf(user.getRole())).build();
    }




}
