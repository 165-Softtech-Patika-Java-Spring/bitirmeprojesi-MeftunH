package com.FinalProject.FinalProject.security.security;

import com.FinalProject.FinalProject.user.entity.User;
import com.FinalProject.FinalProject.user.service.entityService.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserEntityService userEntityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User cusCustomer = userEntityService.getUserByUsername(username);

        return JwtUserDetails.create(cusCustomer);
    }

    public UserDetails loadUserByUserId(Long id) {

        User cusCustomer = userEntityService.getByIdWithControl(id);

        return JwtUserDetails.create(cusCustomer);
    }
}
