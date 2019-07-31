package com.lk.helpdesk.api.security.jwt;

import com.lk.helpdesk.api.entity.User;
import com.lk.helpdesk.api.enums.ProfileEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtUserFactory {

    private JwtUserFactory() { }

    // Cria um Usuario no padrão JWT
    public static JwtUser create(User user) {
        return new JwtUser(user.getId(),
                            user.getEmail(),
                            user.getPassword(),
                            mapToGrantedAuthorities(user.getProfile()));
    }

    // Converte para o padrão JWT
    private static List<? extends GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
        return authorities;
    }
}
