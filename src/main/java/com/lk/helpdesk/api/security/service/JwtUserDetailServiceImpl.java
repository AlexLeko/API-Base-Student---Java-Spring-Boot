package com.lk.helpdesk.api.security.service;

import com.lk.helpdesk.api.entity.User;
import com.lk.helpdesk.api.security.jwt.JwtUserFactory;
import com.lk.helpdesk.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);

        if(user == null){
            throw new UsernameNotFoundException(String.format("No user with username '%s'.", email));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
