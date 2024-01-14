package com.shop.persistence.security.service.impl;

import com.shop.persistence.security.dto.interfaces.UserInterfaces;
import com.shop.persistence.security.entity.RolesSecurityEntity;
import com.shop.persistence.security.service.StaffSecurityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private StaffSecurityService staffSecurityService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInterfaces users= staffSecurityService.getUsuario(username);
        List<RolesSecurityEntity> roles=new ArrayList<>();
        roles.add(users.getRol());
        Collection<? extends GrantedAuthority> authorities=roles.stream()
                .map(rol-> new SimpleGrantedAuthority("ROLE_".concat(rol.getName())))
                .toList();
        return new User(users.getUserName(),users.getPassword(),true,true,true,true,authorities);
    }
}
